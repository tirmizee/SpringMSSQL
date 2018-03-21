package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.Member;

@Repository("MemberRepository")
public class MemberRepositoryImpl extends AbstractJdbcRepository<Member, String> implements MemberRepository {

	public MemberRepositoryImpl() {
		this(T_MEMBER);
	}
	
	public MemberRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, C_USERNAME);
	}
	
	public static final RowMapper<Member> ROW_MAPPER = new RowMapper<Member>() {
		
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member();
			member.setUsername(rs.getString(C_USERNAME));
			member.setPassword(rs.getString(C_PASSWORD));
			member.setFkRoleId(rs.getInt(C_FK_ROLE_ID));
			member.setCreateDate(rs.getDate(C_CERATE_DATE));
			member.setUpdateDate(rs.getDate(C_UPDATE_DATE));
			return member.withPersisted(true);
		}
	};
	
	public static final RowUnmapper<Member> ROW_UNMAPPER = new RowUnmapper<Member>() {
		
		@Override
		public Map<String, Object> mapColumns(Member param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(C_USERNAME, param.getUsername());
			map.put(C_PASSWORD, param.getPassword());
			map.put(C_FK_ROLE_ID, param.getFkRoleId());
			map.put(C_CERATE_DATE, param.getCreateDate());
			map.put(C_UPDATE_DATE, param.getUpdateDate());
			return map;
		}
	};
	
	@Override
	protected <S extends Member> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends Member> S postCreate(S entity, Number generatedId) {
		entity.setPersisted(true);
		return entity;
	}
	

}
