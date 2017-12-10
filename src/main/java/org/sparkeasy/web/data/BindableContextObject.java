package org.sparkeasy.web.data;

import java.util.Map;

public interface BindableContextObject {
	abstract void bindRequestData(Map<String, String[]> requestData);

	abstract Map<String, String> getResponseData();

}
