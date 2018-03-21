package com.tirmizee.repository.entities;

import java.sql.Date;

import org.springframework.data.domain.Persistable;

public class Member implements Persistable<String> {
	
	private static final long serialVersionUID = 5110179478025478941L;
	
	private transient boolean persisted;
	private String username;
	private String password;
	private Integer fkRoleId;
	private Date createDate;
	private Date updateDate;
	
	@Override
	public String getId() {
		return username;
	}

	@Override
	public boolean isNew() {
		return !persisted;
	}
	
	public Member withPersisted(boolean persisted) {
		this.persisted = persisted;
		return this;
	}

	public boolean isPersisted() {
		return persisted;
	}

	public void setPersisted(boolean persisted) {
		this.persisted = persisted;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getFkRoleId() {
		return fkRoleId;
	}

	public void setFkRoleId(Integer fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
