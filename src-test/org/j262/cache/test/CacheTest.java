package org.j262.cache.test;

import junit.framework.TestCase;

import org.j262.cache.Cache;
import org.j262.cache.Cache.CacheType;
import org.j262.cache.exception.CacheException;
import org.junit.Test;

/**
 * @author batsura-sa
 */
public class CacheTest extends TestCase {
	
	@Test
	public void testCacher() throws CacheException {
		 int maxCount=1000;
		 
		 Cache<Integer, Integer> cahe = new Cache<Integer, Integer>(CacheType.L1L2, (maxCount/2)-1, (maxCount/2)-1);
		 
		 for(int i=0;i<maxCount;i++) {
			 cahe.put(new Integer(i), new Integer(-i));
		 }
		 
		 assertNull("Number "+1+" leaved cache, but we found it", cahe.get(1));
		 assertNotNull("Number "+(maxCount-1)+" must be in cache", cahe.get(maxCount-1));
		 assertNull("Number "+(maxCount)+" don't be in cache", cahe.get(maxCount));
		
	}

}
