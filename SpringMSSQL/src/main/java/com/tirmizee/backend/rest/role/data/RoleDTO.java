package com.tirmizee.backend.rest.role.data;

import java.io.Serializable;
import java.sql.Date;

public class RoleDTO implements Serializable{
	
	private static final long serialVersionUID = 8360443020472718088L;
	
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
	
}
