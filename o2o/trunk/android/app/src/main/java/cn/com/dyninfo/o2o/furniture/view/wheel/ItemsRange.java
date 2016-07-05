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

/**
 * Range for visible items.
 */
public class ItemsRange {
	// First item number
	private int first;
	
	// Items count
	private int count;

	/**
	 * Default constructor. Creates an empty range
	 */
    public ItemsRange() {
        this(0, 0);
    }
    
	/**
	 * Constructor
	 * @param first the number of first item
	 * @param count the count of items
	 */
	public ItemsRange(int first, int count) {
		this.first = first;
		this.count = count;
	}
	
	/**
	 * Gets number of  first item
	 * @return the number of the first item
	 */
	public int getFirst() {
		return first;
	}
	
	/**
	 * Gets number of last item
	 * @return the number of last item
	 */
	public int getLast() {
		return getFirst() + getCount() - 1;
	}
	
	/**
	 * Get items count
	 * @return the count of items
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Tests whether item is contained by range
	 * @param index the item number
	 * @return true if item is contained
	 */
	public boolean contains(int index) {
		return index >= getFirst() && index <= getLast();
	}
}