/**
 * 
 */
package com.redv.jdigg;

/**
 * @author sutra
 * 
 */
public class StoryAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5328153852552911535L;

	/**
	 * 
	 */
	public StoryAlreadyExistsException() {
	}

	/**
	 * @param message
	 */
	public StoryAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public StoryAlreadyExistsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StoryAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
