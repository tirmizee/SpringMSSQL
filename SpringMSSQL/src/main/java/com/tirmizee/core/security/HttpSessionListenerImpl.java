package com.tirmizee.core.security;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class HttpSessionListenerImpl implements HttpSessionListener {

	private static final Logger LOG = Logger.getLogger(HttpSessionListenerImpl.class); 
	
	public static int MAX_SESSION_INACTIVE = 30;
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		 LOG.debug("==== Session is created ====");	
		 event.getSession().setMaxInactiveInterval(MAX_SESSION_INACTIVE * 60);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		 LOG.debug("==== Session is destroyed ====");
	}

}
