package org.sparkeasy.web.data;

import java.util.HashMap;
import java.util.Map;

public class MapContextObject implements ContextObject, BindableContextObject {
	protected Map<String, String[]> requestDataMap;
	protected Map<String, String> responseDataMap;

	public MapContextObject() {
		requestDataMap = new HashMap<String, String[]>();
		responseDataMap = new HashMap<String, String>();
	}

	@Override
	public void bindRequestData(Map<String, String[]> requestData) {
		this.requestDataMap = requestData;
	}

	@Override
	public Map<String, String> getResponseData() {
		return responseDataMap;
	}

	@Override
	public void addAttribute(String key, String value) {
		this.responseDataMap.put(key, value);
	}

	@Override
	public String getAttribute(String key) {
		return requestDataMap.get(key)[0];
	}

}
