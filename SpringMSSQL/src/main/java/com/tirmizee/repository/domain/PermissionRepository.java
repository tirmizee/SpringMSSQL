package com.tirmizee.repository.domain;

import com.tirmizee.jdbcrepository.JdbcRepository;
import com.tirmizee.repository.entities.Permission;

public interface PermissionRepository extends JdbcRepository<Permission, Long> {

	public static final String T_Permission = "Permission";
	public static final String C_PER_ID = "PER_ID";
	public static final String C_PER_CODE = "PER_CODE";
	public static final String C_PER_NAME = "PER_NAME";
	public static final String C_PER_DESC = "PER_DESC";
	public static final String C_CREATE_DATE = "CREATE_DATE";
	public static final String C_UPDATE_DATE = "UPDATE_DATE";

}
