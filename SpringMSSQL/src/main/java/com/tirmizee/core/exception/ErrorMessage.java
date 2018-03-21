package com.tirmizee.core.exception;

import java.io.Serializable;

/**
 * @author pratya yeekhaday
 *
 */
public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = -2285899038192730697L;
	
	private String errorCode;
	private String errorName;
	private String errorDescription;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
}
