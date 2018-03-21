package com.tirmizee.backend.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.dao.PermissionDao;
import com.tirmizee.backend.rest.permission.data.PermissionCriteriaDTO;
import com.tirmizee.backend.rest.permission.data.PermissionDTO;
import com.tirmizee.backend.rest.permission.data.PermissionEditDTO;
import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.datatable.PageRequestHelper;
import com.tirmizee.core.datatable.RequestData;
import com.tirmizee.repository.entities.Permission;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
	

	@Autowired 
	PermissionDao permissionDao; 
	
	@Autowired
	CustomMapper mapper;
	
	@Override
	public Page<Permission> findAll(RequestData<PermissionCriteriaDTO> request) {
		PageRequest pageRequest = PageRequestHelper.build(request,PermissionDTO.class);
		return permissionDao.findByCriterira(request.getSerch(), pageRequest);
	}

	@Override
	public Boolean edit(PermissionEditDTO request) {
		Permission entity = permissionDao.findOne(request.getPerId());
		mapper.map(request,entity);
		entity.setUpdateDate(new Date(new java.util.Date().getTime()));
		return permissionDao.save(entity) != null;
	}
	
}
