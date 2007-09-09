/**
 * 
 */
package com.redv.jdigg;

/**
 * @author sutra
 * 
 */
public class UserNotLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6150619236084652565L;

	/**
	 * 
	 */
	public UserNotLoginException() {
	}

	/**
	 * @param message
	 */
	public UserNotLoginException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UserNotLoginException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UserNotLoginException(String message, Throwable cause) {
		super(message, cause);
	}

}
