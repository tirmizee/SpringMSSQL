package com.tirmizee.backend.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.rest.permission.data.PermissionCriteriaDTO;
import com.tirmizee.repository.PermissionRepository;
import com.tirmizee.repository.domain.Permission;

public interface PermissionDao extends PermissionRepository{
	
	List<Permission> findByUsername(String username);
	
	Page<Permission> findByCriterira(PermissionCriteriaDTO criteria,Pageable pageable);
	
}
