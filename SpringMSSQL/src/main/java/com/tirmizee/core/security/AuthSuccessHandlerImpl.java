package com.tirmizee.core.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthSuccessHandlerImpl implements AuthenticationSuccessHandler {

	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication Auth) throws IOException, ServletException {
		String targetUrl = determineTargetUrl(Auth); 
       	redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(Authentication authentication) {
		Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		if (isAdmin(authorities)) {
			return "/admin";
		} else if (isUser(authorities)) {
			return "/user";
		} else {
		    throw new IllegalStateException("not found url succuess handler");
		}
	}
	
	private boolean isAdmin(Collection<String> authorities){
		return authorities.contains("AD000");
	}
	
	private boolean isUser(Collection<String> authorities){
		return authorities.contains("US000");
	}

}
