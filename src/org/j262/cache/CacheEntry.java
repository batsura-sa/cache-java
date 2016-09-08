package org.j262.cache;

import java.io.Serializable;

/** 
 *	@author batsura-sa
 */

public class CacheEntry<T,T1> implements Serializable {

	private T key;
	private T1 value;
	private CacheEntryStat stat;

	public CacheEntry(T key, T1 value) {
		this.key = key;
		this.value = value;
		this.stat = new CacheEntryStat();
	}

	public T getKey() {
		return key;
	}

	public T1 getValue() {
		stat.inc();
		return value;
	}
	
	public void setValue(T1 value) {
		this.value = value;
	}
	
	
}
