package com.tirmizee.repository;

import com.tirmizee.jdbcrepository.JdbcRepository;
import com.tirmizee.repository.domain.Role;

public interface RoleRepository extends JdbcRepository<Role, Integer> {

	public static final String T_ROLE = "Role";
	public static final String C_ROLE_ID = "ROLE_ID";
	public static final String C_ROLE_NAME = "ROLE_NAME";
	public static final String C_ROLE_DESC = "ROLE_DESC";
	public static final String C_CREATE_DATE = "CREATE_DATE";
	public static final String C_UPDATE_DATE = "UPDATE_DATE";
	
}
