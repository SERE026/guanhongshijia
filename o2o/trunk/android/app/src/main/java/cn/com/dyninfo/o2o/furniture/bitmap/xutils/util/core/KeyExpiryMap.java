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

package cn.com.dyninfo.o2o.furniture.bitmap.xutils.util.core;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: wyouflf
 * Date: 13-8-1
 * Time: 上午11:25
 */
public class KeyExpiryMap<K, V> extends ConcurrentHashMap<K, Long> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;

    public KeyExpiryMap(int initialCapacity, float loadFactor, int concurrencyLevel) {
        super(initialCapacity, loadFactor, concurrencyLevel);
    }

    public KeyExpiryMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
    }

    public KeyExpiryMap(int initialCapacity) {
        super(initialCapacity);
    }

    public KeyExpiryMap() {
        super();
    }

    @Override
    public synchronized Long get(Object key) {
        if (this.containsKey(key)) {
            return super.get(key);
        } else {
            return null;
        }
    }

    @Override
    public synchronized Long put(K key, Long expiryTimestamp) {
        if (this.containsKey(key)) {
            this.remove(key);
        }
        return super.put(key, expiryTimestamp);
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        boolean result = false;
        if (super.containsKey(key)) {
            if (System.currentTimeMillis() < super.get(key)) {
                result = true;
            } else {
                this.remove(key);
            }
        }
        return result;
    }

    @Override
    public synchronized Long remove(Object key) {
        return super.remove(key);
    }

    @Override
    public synchronized void clear() {
        super.clear();
    }
}
