/**
 * 
 */
package com.redv.jdigg;

/**
 * @author sutra
 * 
 */
public class StoryNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3563297462376440913L;

	/**
	 * 
	 */
	public StoryNotFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public StoryNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public StoryNotFoundException(Throwable cause) {
		super(cause);
	}

}
