package org.j262.cache.demo;

import org.j262.cache.Cache;
import org.j262.cache.Cache.CacheType;
import org.j262.cache.exception.CacheException;

/** 
 *	@author batsura-sa
 */

public class CacheDemo {
	
	public static int MAX_COUNT=1000;
	
	 public static void main(String[] arg) throws CacheException {
		 Cache<Integer, Integer> cahe = new Cache<Integer, Integer>(CacheType.L1L2, (MAX_COUNT/2)-1, (MAX_COUNT/2)-1);
		 
		 for(int i=0;i<MAX_COUNT;i++) {
			 cahe.put(new Integer(i), new Integer(-i));
		 }
		 
		 for(int i=0;i<MAX_COUNT;i++) {
			 System.out.println( "i=" +i+ " value=" +cahe.get(new Integer(i)) );
		 }
	 }

}
