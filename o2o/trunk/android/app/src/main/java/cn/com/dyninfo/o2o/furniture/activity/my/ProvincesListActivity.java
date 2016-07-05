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

package cn.com.dyninfo.o2o.furniture.activity.my;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.SortAdapter;
import cn.com.dyninfo.o2o.furniture.bean.SortModel;
import cn.com.dyninfo.o2o.furniture.util.CharacterParser;
import cn.com.dyninfo.o2o.furniture.util.PinyinComparator;
import cn.com.dyninfo.o2o.furniture.view.ClearEditText;
import cn.com.dyninfo.o2o.furniture.view.SideFastQueryBar;
import cn.com.dyninfo.o2o.furniture.view.SideFastQueryBar.OnTouchingLetterChangedListener;

/**
 * @Description 选择所在地区（省市） （入口隐藏了）
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-6 下午5:52:51
 * @update 2014-5-16 17:46:42 更新【重庆市】读音识别错误(cq被识别为zq，增加字母，显示时隐藏)
 */
public class ProvincesListActivity extends BaseActivity {

	private String PAGE_TITLE = "选择所在地区";
	private String tag = " ProvincesListActivity ";
	private int layoutID = R.layout.provinces_list;
	private Context context;
	private Handler handler;
	private ListView sortListView;
	private SideFastQueryBar SideFastQueryBar;
	private TextView dialog;
	private SortAdapter adapter;
	private ClearEditText mClearEditText;

	/**
	 * 汉字转换成拼音的类
	 */
	private CharacterParser characterParser;
	private List<SortModel> SourceDateList;

	/**
	 * 根据拼音来排列ListView里面的数据类
	 */
	private PinyinComparator pinyinComparator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		addToActManager(this);
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		initViews();
	}

	private void initViews() {
		// 汉字转拼音类
		characterParser = CharacterParser.getInstance();
		pinyinComparator = new PinyinComparator();

		SideFastQueryBar = (SideFastQueryBar) findViewById(R.id.sidrbar);
		SideFastQueryBar.setAlpha(0.8f);
		dialog = (TextView) findViewById(R.id.dialog);
		dialog.setAlpha(0.6f);
		SideFastQueryBar.setTextView(dialog);

		// 右侧触摸监听
		SideFastQueryBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {
			@Override
			public void onTouchingLetterChanged(String s) {
				// 该字母首次出现的位置
				int position = adapter.getPositionForSection(s.charAt(0));
				if (position != -1) {
					sortListView.setSelection(position);
				}
			}
		});

		sortListView = (ListView) findViewById(R.id.listview);
		sortListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 这里要利用adapter.getItem(position)来获取当前position所对应的对象
				// Log_info("选择了：" + ((SortModel)
				// adapter.getItem(position)).getName());
				Intent intent = new Intent();
				intent.putExtra("provinces", ((SortModel) adapter.getItem(position)).getName().substring(1));
				setResult(RESULT_OK, intent);
				myfinish();
			}
		});

		// 数据源：来自 R.values.arrays
		SourceDateList = filledData(getResources().getStringArray(R.array.provinces)); // 我国省市

		// 根据a-z进行排序源数据
		Collections.sort(SourceDateList, pinyinComparator);
		adapter = new SortAdapter(this, SourceDateList);
		sortListView.setAdapter(adapter);

		mClearEditText = (ClearEditText) findViewById(R.id.filter_edit);

		// 根据输入框输入值的改变来过滤搜索
		mClearEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// 当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
				filterData(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	/**
	 * 为ListView填充数据
	 * 
	 * @param date
	 */
	private List<SortModel> filledData(String[] date) {
		List<SortModel> mSortList = new ArrayList<SortModel>();

		for (int i = 0; i < date.length; i++) {
			SortModel sortModel = new SortModel();
			sortModel.setName(date[i]);
			// 汉字转换成拼音
			String pinyin = characterParser.getSelling(date[i]);
			String sortString = pinyin.substring(0, 1).toUpperCase();

			// 判断首字母是否是英文字母
			if (sortString.matches("[A-Z]")) {
				sortModel.setSortLetters(sortString.toUpperCase());
			} else {
				sortModel.setSortLetters("#");
			}

			mSortList.add(sortModel);
		}
		return mSortList;

	}

	/**
	 * 根据输入框中的值来过滤数据并更新ListView
	 * 
	 * @param filterStr
	 */
	private void filterData(String filterStr) {
		List<SortModel> filterDateList = new ArrayList<SortModel>();

		if (TextUtils.isEmpty(filterStr)) {
			filterDateList = SourceDateList;
		} else {
			filterDateList.clear();
			for (SortModel sortModel : SourceDateList) {
				String name = sortModel.getName();
				if (name.indexOf(filterStr.toString()) != -1
						|| characterParser.getSelling(name).startsWith(filterStr.toString())) {
					filterDateList.add(sortModel);
				}
			}
		}

		// 根据a-z进行排序
		Collections.sort(filterDateList, pinyinComparator);
		adapter.updateListView(filterDateList);
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}
}