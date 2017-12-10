package org.sparkeasy.spi.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sparkeasy.spi.config.MetadataContext;
import org.sparkeasy.spi.exception.DispatcherException;

public class Dispatcher {
	public static void dispatch(HttpServletRequest request,
			HttpServletResponse response, String outcome) {
		MetadataContext metadataContext = null;
		String action = null;
		String view = null;

		try {
			action = request.getServletPath();
			metadataContext = MetadataContext.getInstance();
			view = metadataContext.getView(action, outcome);
			request.getRequestDispatcher(view).forward(request, response);
		} catch (Exception e) {
			throw new DispatcherException("unable to dispatch to view", e);
		}
	}
}
