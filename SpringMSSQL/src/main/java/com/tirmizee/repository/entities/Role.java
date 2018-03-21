package com.tirmizee.repository.entities;

import java.sql.Date;

import org.springframework.data.domain.Persistable;

public class Role implements Persistable<Integer> {

	private static final long serialVersionUID = -2396464053320366483L;
	
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Date createDate;
	private Date updateDate;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
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

	@Override
	public Integer getId() {
		return roleId;
	}

	@Override
	public boolean isNew() {
		return roleId == null;
	}

}
