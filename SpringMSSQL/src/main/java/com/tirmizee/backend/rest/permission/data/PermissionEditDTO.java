package com.tirmizee.backend.rest.permission.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class PermissionEditDTO implements Serializable{

	private static final long serialVersionUID = 4806370948245283200L;
	
	@NotNull 
	private Long perId;
	private String perName;
	private String perDesc;
	
	public Long getPerId() {
		return perId;
	}
	public void setPerId(Long perId) {
		this.perId = perId;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public String getPerDesc() {
		return perDesc;
	}
	public void setPerDesc(String perDesc) {
		this.perDesc = perDesc;
	}

}
