package org.sparkeasy.web.data;


public interface ContextObject {

	void addAttribute(String key, String value);

	String getAttribute(String key);
}
