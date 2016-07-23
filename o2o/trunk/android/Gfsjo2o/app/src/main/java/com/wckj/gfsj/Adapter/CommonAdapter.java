package com.wckj.gfsj.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class CommonAdapter<T> extends BaseAdapter {
	protected LayoutInflater mInflater;
	protected Context mContext;
	protected List<T> mDatas;
	protected final int mItemLayoutId;
	protected T[] str;

	public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mDatas = mDatas;
		this.mItemLayoutId = itemLayoutId;
	}
//	/**
//	 * 只是本地得用数组的时候用到
//	 */
//	public CommonAdapter(Context context,T[] str, int itemLayoutId) {
//		this.mContext = context;
//		this.str=str;
//		this.mInflater = LayoutInflater.from(mContext);
//		this.mItemLayoutId = itemLayoutId;
//	}

	@Override
	public int getCount() {
		if(str!=null){
			return str.length;
		}
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		if(str!=null){
			return str[position];
		}
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
		convert(viewHolder, getItem(position),position);
		return viewHolder.getConvertView();

	}
	
	public void notifyData() {
		notifyDataSetChanged();
	}
	public abstract void convert(ViewHolder helper, T item, int position);

	private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
		return ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
	}

}
