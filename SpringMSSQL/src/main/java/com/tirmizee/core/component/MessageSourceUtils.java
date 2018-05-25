package com.tirmizee.core.component;

import java.util.Locale;

import org.springframework.context.HierarchicalMessageSource;

public interface MessageSourceUtils extends HierarchicalMessageSource{
	
	String getMessage(String code, Object...args);

	String getMessage(Locale locale, String code, Object...args);
	
	String getMessageOrDefault(String defaultMessage, String code, Object...args);
	
	String getMessageOrDefault(String defaultMessage,Locale locale, String code, Object...args);
	
}
