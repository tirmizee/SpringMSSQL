package com.tirmizee.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tirmizee.core.component.MessageSourceUtils;
import com.tirmizee.core.component.MessageSourceUtilsImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.tirmizee.config",
								"com.tirmizee.backend",
								"com.tirmizee.core"})
public class AppConfig {
	
    @Bean
	public MessageSourceUtils messageSource() {
        MessageSourceUtilsImpl messageSource = new MessageSourceUtilsImpl();
        messageSource.setBasename("classpath:messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
