package com.rbac.demo.exception;



public class CustomException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1122659192148398463L;

	public CustomException(String message) {
        super(message);
    }
}
