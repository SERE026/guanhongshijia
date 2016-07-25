package com.wckj.gfsj.CustomUi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

import com.wckj.gfsj.R;

/**
 * 默认没有下啦，通过setpageByShow传入当前得页码总数判断是否下啦
 * @author win 7
 *
 */
public class RefreshListView extends GridViewWithHeaderAndFooter implements OnScrollListener{

	private View footerView;
	private int footerViewHeight;
	
	private int headerViewHeight;//headerView高
	
	private int downY;//按下时y坐标


	private boolean isLoadingMore = false;//当前是否正在处于加载更多

	public RefreshListView(Context context) {
		super(context);
		init();
	}

	public RefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}


	private void init(){
		setOnScrollListener(this);
		initFooterView();
	}



	private void initFooterView() {
		footerView = View.inflate(getContext(), R.layout.layout_footer, null);
		footerView.measure(0, 0);//主动通知系统去测量该view;
		footerViewHeight = footerView.getMeasuredHeight();
		footerView.setPadding(0, -footerViewHeight, 0, 0);
		addFooterView(footerView,null,false);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			downY = (int) ev.getY();
			break;
		case MotionEvent.ACTION_POINTER_UP:
			// 过滤多点触碰
			downY = -1;
			break;
		case MotionEvent.ACTION_MOVE:
			if(downY==-1){
				break;
			}
			break;
		case MotionEvent.ACTION_UP:
			downY=-1;
			break;
		}
		return super.onTouchEvent(ev);
	}


	
	/**
	 * 完成刷新操作，重置状态,在你获取完数据并更新完adater之后，去在UI线程中调用该方法
	 */
	public void completeRefresh(){
		if(isLoadingMore){
			//重置footerView状态
			footerView.setPadding(0, -footerViewHeight, 0, 0);
			isLoadingMore = false;
		}
	}
	

	private OnRefreshListener listener;
	public void setOnRefreshListener(OnRefreshListener listener){
		this.listener = listener;
	}
	public interface OnRefreshListener{
		void onLoadingMore();
	}
	
	
	/**
	 * SCROLL_STATE_IDLE:闲置状态，就是手指松开
	 * SCROLL_STATE_TOUCH_SCROLL：手指触摸滑动，就是按着来滑动
	 * SCROLL_STATE_FLING：快速滑动后松开
	 */
	OnScrollListener mItemClickListener=null;
	/**
	 * 重新模拟onscroll监听要不能onscrollLIStener一直不为空无法执行
	 * @param l
	 */
	public void setOnScroll(OnScrollListener l) {
		mItemClickListener=l;
	}
	@Override
	public void setOnScrollListener(OnScrollListener l) {
		super.setOnScrollListener(this);
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		if(page!=pageCont){
		if(scrollState==OnScrollListener.SCROLL_STATE_IDLE 
				&& getLastVisiblePosition()==(getCount()-1) &&!isLoadingMore&&getFirstVisiblePosition()!=0){
				isLoadingMore = true;
				footerView.setPadding(0, 0, 0, 0);//显示出footerView
				setSelection(getCount());//让listview最后一条显示出来
				if(listener!=null){
					listener.onLoadingMore();
				}
		}
		}
	if(mItemClickListener!=null){
		mItemClickListener.onScrollStateChanged(view, scrollState);
	}
	mCurrentPosition = getFirstVisiblePosition();
	}
	private int page;
	private int pageCont;
	private int mCurrentPosition;
	
	public int getmCurrentPosition() {
		return mCurrentPosition;
	}

	/**
	 * 设置当前得页码，和页数总数，默认为0没有下啦
	 * @param page
	 * @param pageCont
	 */
	public void setPageByShow(int page,int pageCont) {
		this.page=page;
		this.pageCont=pageCont;
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		
	}
	
}
