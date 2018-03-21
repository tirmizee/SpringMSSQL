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

import com.tirmizee.backend.rest.permission.data.PermissionCriteriaDTO;
import com.tirmizee.core.config.AppConfig;
import com.tirmizee.repository.entities.Permission;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class PermissionDaoTest {
	
	@Autowired 
	PermissionDao permissionDao;
	
	@Test
	public void PageOfPermissionWhenFindByCriteria(){
		
		//given
		final String perCode = "AD";
		final String perName = "admin";
		PermissionCriteriaDTO criteria = new PermissionCriteriaDTO();
		criteria.setPerCode(perCode);
		criteria.setPerName(perName);
		Pageable pageable = new PageRequest(0, 20);
		
		//when
		Page<Permission> page = permissionDao.findByCriterira(criteria, pageable);
		System.out.println(page.getNumber());
		System.out.println(page.getSize());
		System.out.println(page.getTotalElements());
		System.out.println(page.getTotalPages());
		System.out.println(page.getContent().get(0).getPerCode());
		//then
		assertThat(page.getContent()).isNotEmpty();
		
	}

}
