package org.j262.cache;

import java.io.Serializable;

/** 
 *	@author batsura-sa
 */

public class CacheEntryStat implements Serializable {
	private volatile int  count;
	private volatile long time;
	
	public CacheEntryStat() {
		this.count = 0;
		this.time = 0;
	}

	public int getCount() {
		return count;
	}

	public void inc() {
		time=System.currentTimeMillis();
		count++;
	}

	public long getTime() {
		return time;
	}
	
}
