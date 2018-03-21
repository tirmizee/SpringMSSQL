package com.tirmizee.core.exception;

import org.springframework.http.HttpStatus;

/**
 * @author pratya yeekhaday
 *
 */
public class BussinesException extends RuntimeException {

	private static final long serialVersionUID = 1016513180537286253L;
	
	private String code;
	private Object args[];
	private HttpStatus status;
	
	public BussinesException(HttpStatus status,String code,Object...args) {
		this.code = code;
		this.args = args;
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public Object[] getArgs() {
		return args;
	}
	
}
