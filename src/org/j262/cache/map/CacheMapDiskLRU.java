package org.j262.cache.map;

/** 
 *	@author batsura-sa
 */

//TODO Бацура 28.07.2016 сделать дисковый LRU cache
public class CacheMapDiskLRU<T, T1> extends CacheMapMemLRU<T, T1> implements CacheMap<T, T1> {

	public CacheMapDiskLRU(int maxSize) {
		super(maxSize);
	}
}