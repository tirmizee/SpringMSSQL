package com.tirmizee.repository.domain;

import java.sql.Date;

import org.springframework.data.domain.Persistable;

public class Permission implements Persistable<Long> {

	private static final long serialVersionUID = -1527771804161271659L;

	private Long perId;
	private String perCode;
	private String perName;
	private String perDesc;
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

	@Override
	public Long getId() {
		return perId;
	}

	@Override
	public boolean isNew() {
		return perId == null;
	}
 
}
