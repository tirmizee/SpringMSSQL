package com.tirmizee.core.commons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

/**
 * @author pratya yeekhaday
 *
 */
@Component
public class LabelManager {
	
	public static final String TXT = ".txt";
	public static final String PRE_PATH = "classpath:i18n/page/";
	public static final String DEFUALT_HEADER = "header_";
	public static final String DEFUALT_FOOTER = "footer_";
	public static final String DEFUALT_SIDEBAR_MENU = "sidebar_menu_";
	
	@SuppressWarnings("resource")
	public Map<String, String> load(String path){
		String result = null;
		try {
			File file = ResourceUtils.getFile(PRE_PATH + path);
			result = new Scanner(file).useDelimiter("\\Z").next();
		} 
		catch (IOException e) { e.printStackTrace(); } 
		return toMap(result);
	}
	
	/**
	* load label name herder,side bar and footer
	*
	*/
	public Map<String, String> loadAll(String path,Locale locale){
		Map<String, String> mapAll = new HashMap<>();
		mapAll.putAll(load(path + locale.getLanguage() + TXT));
		mapAll.putAll(load(DEFUALT_HEADER + locale.getLanguage() + TXT));
		mapAll.putAll(load(DEFUALT_FOOTER + locale.getLanguage() + TXT));
		mapAll.putAll(load(DEFUALT_SIDEBAR_MENU + locale.getLanguage() + TXT));
		return mapAll;
	}

	private Map<String, String> toMap(String text) {
		if (text == null) { return null; }
		Map<String, String> properties = new HashMap<>();
		String rows[] = text.split("\\s*\n\\s*");
		for (String row : rows) {
			String culumns[] = row.split("\\s*=\\s*");
			properties.put(culumns[0], culumns[1]);
		}
		return properties;
	}
	
}
