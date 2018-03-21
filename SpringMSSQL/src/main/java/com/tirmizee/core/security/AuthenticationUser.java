package com.tirmizee.core.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUser {
	
	@Autowired
	HttpServletRequest request;
	
	private String accessIp;
	
	public UserProfile getUserProfile(){
		accessIp = request.getRemoteAddr();
		return (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public String getAccessIp() {
		return accessIp;
	}
	
}
