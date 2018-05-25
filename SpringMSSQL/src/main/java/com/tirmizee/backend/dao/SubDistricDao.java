package com.tirmizee.backend.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.rest.address.data.AddressCritiriaDTO;
import com.tirmizee.backend.rest.address.data.AddressDTO;
import com.tirmizee.repository.SubDistrictRepository;

public interface SubDistricDao  extends SubDistrictRepository{
	
	Page<AddressDTO> findByCriteria(AddressCritiriaDTO criteria,Pageable pageable,String lang);

}
