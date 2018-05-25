package com.tirmizee.backend.rest.permission;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.rest.permission.data.PermissionCriteriaDTO;
import com.tirmizee.backend.rest.permission.data.PermissionDTO;
import com.tirmizee.backend.rest.permission.data.PermissionEditDTO;
import com.tirmizee.backend.service.PermissionService;
import com.tirmizee.core.annotaion.RestPostMapping;
import com.tirmizee.core.component.GTMapper;
import com.tirmizee.core.datatable.RequestData;
import com.tirmizee.core.datatable.ResponseData;
import com.tirmizee.repository.domain.Permission;

@RestController
@RequestMapping(value="/service/permission")
public class RestPermissionController {
	
	@Autowired
	private GTMapper mapper;
	
	@Autowired
	private PermissionService permissionService; 
	
	@PreAuthorize("hasAnyAuthority('PER01')")
	@RestPostMapping(value="/findAll")
	public ResponseData<PermissionDTO> findAll(@Valid @RequestBody RequestData<PermissionCriteriaDTO> request){
		Page<Permission> page = permissionService.findAll(request);
		return new ResponseData<>(mapper.map(page, PermissionDTO.class));
	}
	
	@PreAuthorize("hasAnyAuthority('PER01')")
	@RestPostMapping(value="/edit")
	public ResponseEntity<Boolean> edit(@Valid @RequestBody PermissionEditDTO request){
		return new ResponseEntity<>(permissionService.edit(request),HttpStatus.OK);
	}
	
}
