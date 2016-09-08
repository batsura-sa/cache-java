package org.j262.cache.map;

import java.util.LinkedHashMap;
import java.util.Map;

import org.j262.cache.CacheEntry;
import org.j262.cache.exception.CacheException;

/** 
 *	@author batsura-sa
 */

public class CacheMapMemLRU<T, T1> implements CacheMap<T, T1> {
	private Map<T, CacheEntry<T, T1>> cache;
	private CacheEntry<T, T1> lastDeletedCacheEntry;
	private final int maxSize;

	public CacheMapMemLRU(int maxSize2) {
		this.maxSize = maxSize2;
		cache = new LinkedHashMap<T, CacheEntry<T,T1>>(maxSize, 0.75f, true) {
			private static final long serialVersionUID = 1L;
			@Override
			protected boolean removeEldestEntry(Map.Entry<T, CacheEntry<T, T1>> eldest) {
				boolean delete=size()>maxSize;
				if ( delete ) {
					lastDeletedCacheEntry=eldest.getValue();
					return true;
				}
				return false;
			}
		};
	}
	
	@Override
	public void put(T key, T1 value) throws CacheException {
		lastDeletedCacheEntry=null;
		cache.put(key, new CacheEntry<T, T1>(key, value));
	}

	@Override
	public T1 get(T key) {
		CacheEntry<T, T1> entry=cache.get(key);
		if ( entry!=null )
			return entry.getValue();
		return null;
	}

	@Override
	public CacheEntry<T, T1> getLastDeletedEntry() {
			return lastDeletedCacheEntry;
		
	}
}