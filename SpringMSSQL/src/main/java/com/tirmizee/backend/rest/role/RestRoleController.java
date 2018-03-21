package com.tirmizee.backend.rest.role;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.rest.role.data.RoleDTO;
import com.tirmizee.core.datatable.RequestData;
import com.tirmizee.core.datatable.ResponseData;

@RestController
@RequestMapping(value = "service/role")
public class RestRoleController {

	@PostMapping(value = "/findAll")
	public ResponseData<RoleDTO> findAll(@Valid @RequestBody RequestData<RoleDTO> request){
		return null;
	}
	
}
