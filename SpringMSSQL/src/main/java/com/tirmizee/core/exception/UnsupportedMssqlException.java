package com.tirmizee.core.exception;

public class UnsupportedMssqlException extends RuntimeException {

	private static final long serialVersionUID = 4027091698238074899L;
	
	public UnsupportedMssqlException() {
        super();
    }
	
	public UnsupportedMssqlException(String message){
		super(message);
	}
	
	public UnsupportedMssqlException(Throwable cause) {
        super(cause);
    }
	
}
