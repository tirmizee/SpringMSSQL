package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.Role;

@Repository("RoleRepository")
public class RoleRepositoryImpl extends AbstractJdbcRepository<Role, Integer> implements RoleRepository {

	public RoleRepositoryImpl() {
		this(T_ROLE);
	}
	
	public RoleRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, C_ROLE_ID);
	}
	
	public static final RowMapper<Role> ROW_MAPPER = new RowMapper<Role>() {
		
		@Override
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			role.setRoleId(rs.getInt(C_ROLE_ID));
			role.setRoleName(rs.getString(C_ROLE_NAME));
			role.setRoleDesc(rs.getString(C_ROLE_DESC));
			role.setCreateDate(rs.getDate(C_CREATE_DATE));
			role.setUpdateDate(rs.getDate(C_UPDATE_DATE));
			return role;
		}
	};
	
	public static final RowUnmapper<Role> ROW_UNMAPPER = new RowUnmapper<Role>() {
		
		@Override
		public Map<String, Object> mapColumns(Role param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(C_ROLE_ID, param.getRoleId());
			map.put(C_ROLE_NAME, param.getRoleName());
			map.put(C_ROLE_DESC, param.getRoleDesc());
			map.put(C_CREATE_DATE, param.getCreateDate());
			map.put(C_UPDATE_DATE, param.getUpdateDate());
			return map;
		}
	};

	@Override
	protected <S extends Role> S postCreate(S entity, Number generatedId) {
		entity.setRoleId(generatedId.intValue());
		return entity;
	}

}
