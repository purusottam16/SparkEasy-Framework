package org.sparkeasy.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sparkeasy.spi.config.MetadataContext;
import org.sparkeasy.spi.config.MetadataContextManager;
import org.sparkeasy.spi.config.XmlMetadataContextManager;
import org.sparkeasy.spi.controller.SparkeasyApplicationController;

public class SparkeasyServlet extends HttpServlet {
	private final String SPARK_CONFIG_NAMESPACE = "/WEB-INF/sparkeasy-web.xml";
	private String SPARK_WEB_CONTEXT_PATH;
	private MetadataContext context;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// request validation
		// system services
		SparkeasyApplicationController.handleRequest(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		MetadataContextManager manager = null;
		ServletContext servletContext = null;

		servletContext = config.getServletContext();
		SPARK_WEB_CONTEXT_PATH = servletContext
				.getRealPath(SPARK_CONFIG_NAMESPACE);

		manager = new XmlMetadataContextManager();
		context = manager.createMetadataContext(SPARK_WEB_CONTEXT_PATH);
	}

}
