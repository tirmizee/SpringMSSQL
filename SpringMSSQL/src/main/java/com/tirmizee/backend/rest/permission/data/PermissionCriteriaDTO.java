package com.tirmizee.backend.rest.permission.data;

import java.io.Serializable;

public class PermissionCriteriaDTO implements Serializable {

	private static final long serialVersionUID = 2090432756910792207L;

	private String PerCode;
	private String PerName;
	
	public String getPerCode() {
		return PerCode;
	}
	public void setPerCode(String perCode) {
		PerCode = perCode;
	}
	public String getPerName() {
		return PerName;
	}
	public void setPerName(String perName) {
		PerName = perName;
	}
	
}
