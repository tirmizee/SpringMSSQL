package com.tirmizee.core.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.core.commons.CustomMapper;


@Configuration
public class DozerMapperConfig {
	
	@Bean	
	public CustomMapper getCustomMapper(){
		return new CustomMapper(Arrays.asList("dozer-config.xml"));
	}

	
}
