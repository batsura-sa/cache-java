package org.j262.cache;

import org.j262.cache.exception.CacheException;
import org.j262.cache.map.CacheMap;
import org.j262.cache.map.CacheMapDiskLRU;
import org.j262.cache.map.CacheMapL1L2;
import org.j262.cache.map.CacheMapMemLRU;

/** 
 *	@author batsura-sa
 */

public class Cache<T,T1> {
	public enum CacheType { LRU_MEMORY, LRU_DISK, L1L2 };
	private CacheMap<T, T1> cache;
	private CacheType cacheType;
	
	public Cache(CacheType cacheType, int maxSize) {
		this(cacheType, maxSize, maxSize);
	}
	
	public Cache(CacheType cacheType, int maxSizeL1, int maxSizeL2) {
		
		this.cacheType = cacheType;
		
		switch (cacheType) {
			case LRU_MEMORY:
				this.cache = new CacheMapMemLRU<T, T1>(maxSizeL1);
				break;
			case LRU_DISK:
				this.cache = new CacheMapDiskLRU<T, T1>(maxSizeL1);
				break;
			case L1L2:
				this.cache = new CacheMapL1L2<T, T1>(maxSizeL1, maxSizeL2);
				break;
				
		}
	}
	
	public void put(T key, T1 value) throws CacheException {
		cache.put(key, value);
	}
	
	public T1 get(T key) {
		 return cache.get(key);
	}
	
	public CacheEntry<T, T1> getLastDeletedEntry() {
		 return cache.getLastDeletedEntry();
	}

	public CacheType getCacheType() {
		return cacheType;
	}
	
}
