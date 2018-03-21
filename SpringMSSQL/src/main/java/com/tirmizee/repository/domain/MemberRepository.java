package com.tirmizee.repository.domain;

import com.tirmizee.jdbcrepository.JdbcRepository;
import com.tirmizee.repository.entities.Member;

public interface MemberRepository extends JdbcRepository<Member, String> {
	
	public static final String T_MEMBER = "Member";
	public static final String C_USERNAME = "USERNAME";
	public static final String C_PASSWORD = "PASSWORD";
	public static final String C_FK_ROLE_ID = "FK_ROLE_ID";
	public static final String C_CERATE_DATE = "CERATE_DATE";
	public static final String C_UPDATE_DATE = "UPDATE_DATE";

}
