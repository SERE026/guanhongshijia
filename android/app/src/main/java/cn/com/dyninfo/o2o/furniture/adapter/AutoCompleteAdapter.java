/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
 * confidential information, ideas and expressions.    No part of this
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

package cn.com.dyninfo.o2o.furniture.adapter;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;

/**
* @Description 自动匹配
* @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
* @created  by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on 2014-9-9 下午3:42:00
 */
public class AutoCompleteAdapter<T> extends BaseAdapter implements Filterable {

	private Context context;
	private final Object mLock = new Object();
	private List<T> values;
	private List<T> keys;
	private ArrayFilter filter;

	public AutoCompleteAdapter(Context context, List<T> values) {
		this.context = context;
		this.keys = values;
		this.values = values;
	}

	@Override
	public int getCount() {
		return values.size();
	}

	@Override
	public Object getItem(int position) {
		return values.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ItemWrapper wrapper = null;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(R.layout.autocomplete_item, null);
			wrapper = new ItemWrapper();
			wrapper.tx = (TextView) view.findViewById(R.id.txt);
			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}
		wrapper.tx.setText(values.get(position).toString());

		return view;
	}

	class ItemWrapper {
		TextView tx;
	}

	@Override
	public Filter getFilter() {
		if (filter == null)
			filter = new ArrayFilter();
		return filter;
	}

	private class ArrayFilter extends Filter {
		@Override
		protected FilterResults performFiltering(CharSequence prefix) {
			FilterResults results = new FilterResults();

			if (prefix == null || prefix.length() == 0) {
				synchronized (mLock) {
					ArrayList<T> list = new ArrayList<T>(keys);
					results.values = list;
					results.count = list.size();
				}
			} else {
				String prefixString = prefix.toString().toLowerCase();
				final List<T> values = keys;
				final int count = values.size();
				final ArrayList<T> newValues = new ArrayList<T>(count);

				for (int i = 0; i < count; i++) {
					final T value = values.get(i);
					final String valueText = value.toString().toLowerCase();

					// 改为不仅仅支持首字符匹配（全字段匹配）
					if (valueText.contains(prefixString)) {
						newValues.add(value);
					} else {
						final String[] words = valueText.split(" ");
						final int wordCount = words.length;

						for (int k = 0; k < wordCount; k++) {
							if (words[k].contains(prefixString)) {
								newValues.add(value);
								break;
							}
						}
					}
				}
				results.values = newValues;
				results.count = newValues.size();
			}
			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			values = (List<T>) results.values;
			if (results.count > 0) {
				notifyDataSetChanged();
			} else {
				notifyDataSetInvalidated();
			}
		}
	}
}
