package com.tirmizee.backend.service;

import org.springframework.data.domain.Page;

import com.tirmizee.backend.rest.permission.data.PermissionCriteriaDTO;
import com.tirmizee.backend.rest.permission.data.PermissionEditDTO;
import com.tirmizee.core.datatable.RequestData;
import com.tirmizee.repository.domain.Permission;

public interface PermissionService {
	
	Boolean edit(PermissionEditDTO request);
	
	Page<Permission> findAll(RequestData<PermissionCriteriaDTO> request);

}
