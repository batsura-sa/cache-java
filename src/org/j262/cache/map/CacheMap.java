package org.j262.cache.map;

import org.j262.cache.CacheEntry;
import org.j262.cache.exception.CacheException;

/** 
 *	@author batsura-sa
 */

public interface CacheMap<T, T1> {
	public void put(T key, T1 value) throws CacheException;
	public T1 get(T key);
	public CacheEntry<T, T1> getLastDeletedEntry();
}
