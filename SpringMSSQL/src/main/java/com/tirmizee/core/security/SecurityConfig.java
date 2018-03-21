package com.tirmizee.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.dao.PermissionDao;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MemberDao memberDao;
	
	@Autowired 
	PermissionDao permissionDao;
	
	@Autowired
	AuthSuccessHandlerImpl successHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder(11);
		return encoder;
	}
	
	@Override
	protected UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl(memberDao, permissionDao);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET, "/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated().and()
		    .formLogin().loginPage("/login").permitAll()
		    .successHandler(successHandler);
	}

}
