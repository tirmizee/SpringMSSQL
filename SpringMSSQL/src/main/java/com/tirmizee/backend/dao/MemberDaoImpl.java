package com.tirmizee.backend.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.sql.SqlGenerator;
import com.tirmizee.repository.domain.MemberRepositoryImpl;
import com.tirmizee.repository.entities.Member;


@Repository("MemberDao")
public class MemberDaoImpl extends MemberRepositoryImpl implements MemberDao {

	@Override
	public Member findByUsername(String username) {
		StringBuilder select = new StringBuilder()
			.append(SqlGenerator.SELECT).append(" * ")
			.append(SqlGenerator.FROM).append(T_MEMBER)
			.append(SqlGenerator.WHERE).append(C_USERNAME)
			.append(SqlGenerator.PARAM);
		try {
			return getJdbcOps().queryForObject(select.toString(), new Object[]{username}, ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

}
