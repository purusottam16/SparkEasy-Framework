package org.sparkeasy.spi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sparkeasy.spi.helper.Dispatcher;
import org.sparkeasy.spi.helper.SparkeasyActionHelper;
import org.sparkeasy.spi.mapper.HttpMapper;
import org.sparkeasy.spi.mapper.Mapper;
import org.sparkeasy.web.command.SparkeasyAction;
import org.sparkeasy.web.data.BindableContextObject;
import org.sparkeasy.web.data.ContextObject;
import org.sparkeasy.web.data.ContextObjectFactory;

public class SparkeasyApplicationController {
	public static void handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		String action = null;
		ContextObject contextObject = null;
		SparkeasyAction sparkeasyAction = null;
		Map<String, String[]> requestData = null;
		Mapper<HttpServletRequest> httpMapper = null;

		action = request.getServletPath();
		contextObject = ContextObjectFactory.createContextObject();
		httpMapper = new HttpMapper();
		requestData = httpMapper.extractData(request);
		((BindableContextObject) contextObject).bindRequestData(requestData);

		sparkeasyAction = SparkeasyActionHelper.getSparkeasyAction(action);
		String outcome = sparkeasyAction.execute(contextObject);

		httpMapper.bindData(contextObject, request);
		Dispatcher.dispatch(request, response, outcome);
	}
}
