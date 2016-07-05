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

public interface WheelAdapter {
	/**
	 * Gets items count
	 * 
	 * @return the count of wheel items
	 */
	public int getItemsCount();

	/**
	 * Gets a wheel item by index.
	 * 
	 * @param index
	 *            the item index
	 * @return the wheel item text or null
	 */
	public String getItem(int index);

	/**
	 * Gets maximum item length. It is used to determine the wheel width. If -1
	 * is returned there will be used the default wheel width.
	 * 
	 * @return the maximum item length or -1
	 */
	public int getMaximumLength();
}
