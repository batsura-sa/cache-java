package org.j262.cache.exception;

/** 
 *	@author batsura-sa
 */

public class CacheException extends Exception {

	public CacheException() {
		super();
	}

	public CacheException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CacheException(String message, Throwable cause) {
		super(message, cause);
	}

	public CacheException(String message) {
		super(message);
	}

	public CacheException(Throwable cause) {
		super(cause);
	}
	
}
