package com.tirmizee.backend.rest.address;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dao.SubDistricDao;
import com.tirmizee.backend.rest.address.data.AddressCritiriaDTO;
import com.tirmizee.backend.rest.address.data.AddressDTO;
import com.tirmizee.core.annotaion.RestPostMapping;
import com.tirmizee.core.datatable.PageRequestHelper;
import com.tirmizee.core.datatable.RequestData;
import com.tirmizee.core.datatable.ResponseData;

@RestController
@RequestMapping(value = "/service/address")
public class RestSubDistrictController {
	
	@Autowired
	SubDistricDao subDistricDao; 
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@RestPostMapping(value="/findByCriteria")
	public ResponseData<AddressDTO> findByCriteria(@Valid @RequestBody RequestData<AddressCritiriaDTO> request){
		Pageable pageable = PageRequestHelper.build(request, AddressDTO.class);
		String lang = LocaleContextHolder.getLocale().getLanguage();
		Page<AddressDTO> page = subDistricDao.findByCriteria(request.getSerch(), pageable,lang);
		return new ResponseData<>(page);
	}
	
}
