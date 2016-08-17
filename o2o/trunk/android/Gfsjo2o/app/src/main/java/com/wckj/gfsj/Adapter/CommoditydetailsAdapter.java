package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.ImageLoaderUtil;

import java.util.ArrayList;
import java.util.List;


public class CommoditydetailsAdapter extends PagerAdapter {
	private List<String> displayImages;
	private Context context;
	private ArrayList<View> viewList = new ArrayList<View>();

	public CommoditydetailsAdapter( List<String> displayImages,
								   Context context) {
		super();
		this.displayImages = displayImages;
		this.context = context;
		for (int i = 0; i < displayImages.size(); i++) {
			View s = LayoutInflater.from(this.context).inflate(
					R.layout.item_view_picture, null);
			ImageView iv_loadpic = (ImageView) s.findViewById(R.id.iv_pictrue);
			ImageLoaderUtil.getInstance().displayImageView(displayImages.get(i),iv_loadpic);
//			iv_loadpic.setImageResource(R.drawable.icon_public_image);
			viewList.add(s);
		}
	}


	@Override
	public int getCount() {
		return viewList.size();
	}

	@Override
	public Object instantiateItem(View view, int position) {
		try {

			((ViewPager) view).addView(viewList.get(position));
		} catch (Exception e) {

		}
		return viewList.get(position);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {

		return arg0 == arg1;
	}
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}
	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}


}
