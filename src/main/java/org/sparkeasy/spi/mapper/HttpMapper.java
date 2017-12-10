package org.sparkeasy.spi.mapper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sparkeasy.web.data.BindableContextObject;
import org.sparkeasy.web.data.ContextObject;

public class HttpMapper implements Mapper<HttpServletRequest> {

	@Override
	public Map<String, String[]> extractData(HttpServletRequest request) {
		return request.getParameterMap();
	}

	@Override
	public void bindData(ContextObject object, HttpServletRequest request) {
		BindableContextObject bindableContextObject = null;
		Map<String, String> responseMap = null;

		bindableContextObject = (BindableContextObject) object;
		responseMap = bindableContextObject.getResponseData();
		for (String key : responseMap.keySet()) {
			request.setAttribute(key, responseMap.get(key));
		}
	}

}
