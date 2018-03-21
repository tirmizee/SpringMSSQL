package com.tirmizee.backend.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.backend.rest.address.data.AddressCritiriaDTO;
import com.tirmizee.backend.rest.address.data.AddressDTO;
import com.tirmizee.core.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class SubDistrictDaoTest {
	
	@Autowired 
	SubDistricDao subDistricDao;
	
	@Test
	public void PageOfAddressDtoWhenFindByCriteria(){
		
		//given
		final String provinceName = " ß¢≈“";
		AddressCritiriaDTO criteria = new AddressCritiriaDTO();
		criteria.setProvinceName(provinceName);
		Pageable pageable = new PageRequest(0, 20);
		
		//when
		Page<AddressDTO> page = subDistricDao.findByCriteria(criteria, pageable,"en");
		System.out.println(page.getNumber());
		System.out.println(page.getSize());
		System.out.println(page.getTotalElements());
		System.out.println(page.getTotalPages());
		
		//then
		assertThat(page.getContent()).isNotEmpty();
		
	}

}
