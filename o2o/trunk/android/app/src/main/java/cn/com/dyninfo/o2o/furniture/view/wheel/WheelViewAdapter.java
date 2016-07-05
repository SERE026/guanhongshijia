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

package cn.com.dyninfo.o2o.furniture.view.wheel;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/**
 * Wheel items adapter interface
 */
public interface WheelViewAdapter {
	/**
	 * Gets items count
	 * @return the count of wheel items
	 */
	public int getItemsCount();
	
	/**
	 * Get a View that displays the data at the specified position in the data set
	 * 
	 * @param index the item index
	 * @param convertView the old view to reuse if possible
	 * @param parent the parent that this view will eventually be attached to
	 * @return the wheel item View
	 */
	public View getItem(int index, View convertView, ViewGroup parent);

	/**
	 * Get a View that displays an empty wheel item placed before the first or after
	 * the last wheel item.
	 * 
	 * @param convertView the old view to reuse if possible
     * @param parent the parent that this view will eventually be attached to
	 * @return the empty item View
	 */
	public View getEmptyItem(View convertView, ViewGroup parent);
	
	/**
	 * Register an observer that is called when changes happen to the data used by this adapter.
	 * @param observer the observer to be registered
	 */
	public void registerDataSetObserver(DataSetObserver observer);
	
	/**
	 * Unregister an observer that has previously been registered
	 * @param observer the observer to be unregistered
	 */
	void unregisterDataSetObserver (DataSetObserver observer);
}
