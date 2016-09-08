package org.j262.cache.map;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.j262.cache.Cache;
import org.j262.cache.Cache.CacheType;
import org.j262.cache.CacheEntry;
import org.j262.cache.exception.CacheException;

/** 
 *	@author batsura-sa
 */

public class CacheMapL1L2<T, T1> implements CacheMap<T, T1> {
	private Cache<T, T1> l1;
	private Cache<T, T1> l2;
	private Lock lock;
	private CacheEntry<T, T1> lastDeletedCacheEntry;


	public CacheMapL1L2(int maxSizeL1, int maxSizeL2) {
		l1 = new Cache<T, T1>(CacheType.LRU_MEMORY, maxSizeL1);
		l2 = new Cache<T, T1>(CacheType.LRU_DISK, maxSizeL2);
		lock = new ReentrantLock();
	}

	@Override
	public void put(T key, T1 value) throws CacheException {
		lock.lock();
		l1.put(key, value);
		CacheEntry<T, T1> cacheEntry=l1.getLastDeletedEntry();
		if ( cacheEntry!=null ) {
			l2.put(cacheEntry.getKey(), cacheEntry.getValue());
			lastDeletedCacheEntry=l2.getLastDeletedEntry();
		}
		lock.unlock();
	}

	@Override
	public T1 get(T key) {
		T1 value=l1.get(key);
		if ( value!=null )
			return value;
		return l2.get(key);
	}

	@Override
	public CacheEntry<T, T1> getLastDeletedEntry() {
		return lastDeletedCacheEntry;
	}
}
