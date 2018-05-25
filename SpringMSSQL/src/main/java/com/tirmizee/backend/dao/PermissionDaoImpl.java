package com.tirmizee.backend.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.rest.permission.data.PermissionCriteriaDTO;
import com.tirmizee.jdbcrepository.sql.SqlGenerator;
import com.tirmizee.repository.PermissionRepositoryImpl;
import com.tirmizee.repository.domain.Permission;

@Repository("PermissionDao")
public class PermissionDaoImpl extends PermissionRepositoryImpl implements PermissionDao {

	@Override
	public List<Permission> findByUsername(String username) {
		StringBuilder select = new StringBuilder()
			.append(SqlGenerator.SELECT).append(" Permission.* ")
			.append(SqlGenerator.FROM).append(" Member ")
			.append(" INNER JOIN ").append(" Role ")
			.append(" ON ").append(" Member.FK_ROLE_ID = Role.ROLE_ID ")
			.append(" INNER JOIN ").append(" Role_Map_Permission ")
			.append(" ON ").append(" Role.ROLE_ID = Role_Map_Permission.FK_ROLE_ID ")
			.append(" INNER JOIN ").append(" Permission ")
			.append(" ON ").append(" Role_Map_Permission.FK_PER_ID = Permission.PER_ID ")
			.append(SqlGenerator.WHERE).append(" USERNAME ").append(SqlGenerator.PARAM);
		return getJdbcOps().query(select.toString(), new Object[]{username}, ROW_MAPPER);
	}

	@Override
	public Page<Permission> findByCriterira(PermissionCriteriaDTO criteria, Pageable pageable) {
		LinkedList<Object> params = new LinkedList<>();
		StringBuilder select = new StringBuilder()
			.append(getSqlGenerator().selectAll(getTable()))
			.append(SqlGenerator.WHERE).append(C_PER_ID)
			.append(" IS NOT NULL ");
		if (criteria.getPerCode() != null) {
			select.append(SqlGenerator.AND)
				.append(C_PER_CODE)
				.append(" LIKE ?");
			params.add(StringUtils.trimToEmpty("%" + criteria.getPerCode() + "%"));
		}
		if (criteria.getPerName() != null) {
			select.append(SqlGenerator.AND)
				.append(C_PER_NAME)
				.append(" LIKE ? ");
			params.add(StringUtils.trimToEmpty("%" + criteria.getPerName() + "%"));
		}
		String sqlStatement = getSqlGenerator().selectAll(getTable(), select, pageable);
		List<Permission> content = getJdbcOps().query(sqlStatement, params.toArray(), ROW_MAPPER);
		long count = count(select.toString(), params.toArray());
		return new PageImpl<Permission>(content,pageable,count);
	}

}
