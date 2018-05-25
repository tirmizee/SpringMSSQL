package com.tirmizee.backend.rest.permission.data;

import java.io.Serializable;
import java.sql.Date;

import com.tirmizee.core.annotaion.SortColumn;
import com.tirmizee.repository.PermissionRepository;

public class PermissionDTO implements Serializable {

	private static final long serialVersionUID = -1580988185567033534L;
	
	private Long perId;
	
	@SortColumn(value = PermissionRepository.C_PER_CODE)
	private String perCode;
	
	@SortColumn(value = PermissionRepository.C_PER_NAME)
	private String perName;
	
	@SortColumn(value = PermissionRepository.C_PER_DESC)
	private String perDesc;
	
	@SortColumn(value = PermissionRepository.C_CREATE_DATE)
	private Date createDate;
	
	private Date updateDate;
	
	public Long getPerId() {
		return perId;
	}
	public void setPerId(Long perId) {
		this.perId = perId;
	}
	public String getPerCode() {
		return perCode;
	}
	public void setPerCode(String perCode) {
		this.perCode = perCode;
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
