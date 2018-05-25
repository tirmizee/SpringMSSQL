package com.tirmizee.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.domain.Permission;

@Repository("PermissionRepository")
public class PermissionRepositoryImpl extends AbstractJdbcRepository<Permission, Long> implements PermissionRepository {

	public PermissionRepositoryImpl() {
		this(T_Permission);
	}
	
	public PermissionRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, C_PER_ID);
	}
	
	public static final RowMapper<Permission> ROW_MAPPER = new RowMapper<Permission>() {
		
		@Override
		public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
			Permission permission = new Permission();
			permission.setPerId(rs.getLong(C_PER_ID));
			permission.setPerCode(rs.getString(C_PER_CODE));
			permission.setPerName(rs.getString(C_PER_NAME));
			permission.setPerDesc(rs.getString(C_PER_DESC));
			permission.setCreateDate(rs.getDate(C_CREATE_DATE));
			permission.setUpdateDate(rs.getDate(C_UPDATE_DATE));
			return permission;
		}
	};
	
	public static final RowUnmapper<Permission> ROW_UNMAPPER = new RowUnmapper<Permission>() {
		
		@Override
		public Map<String, Object> mapColumns(Permission param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(C_PER_ID, param.getPerId());
			map.put(C_PER_CODE, param.getPerCode());
			map.put(C_PER_NAME, param.getPerName());
			map.put(C_PER_DESC, param.getPerDesc());
			map.put(C_CREATE_DATE, param.getCreateDate());
			map.put(C_UPDATE_DATE, param.getUpdateDate());
			return map;
		}
	};

	@Override
	protected <S extends Permission> S postCreate(S entity, Number generatedId) {
		entity.setPerId(generatedId.longValue());
		return entity;
	}
	
	

}
