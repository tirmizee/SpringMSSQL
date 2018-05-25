package com.tirmizee.core.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.core.component.GTMapper;
import com.tirmizee.core.component.GTMapperImpl;


@Configuration
public class DozerMapperConfig {
	
	@Bean	
	public GTMapper getCustomMapper(){
		return new GTMapperImpl(Arrays.asList("dozer-config.xml"));
	}

}