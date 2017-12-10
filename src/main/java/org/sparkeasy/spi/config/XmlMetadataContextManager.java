package org.sparkeasy.spi.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.sparkeasy.spi.exception.MetadataNotInitializedException;
import org.sparkeasy.web.config.SparkeasyConfig;
import org.xml.sax.SAXException;

public class XmlMetadataContextManager implements MetadataContextManager {
	private final String SPARK_CONFIG_LOCATION = "META-INF/sparkeasy-web.xsd";

	public MetadataContext createMetadataContext(String contextPath) {
		Unmarshaller unmarshaller = null;
		MetadataContext context = null;
		SchemaFactory sfactory = null;
		Schema sparkWebSchema = null;
		JAXBContext jContext = null;

		try {
			sfactory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			sparkWebSchema = sfactory.newSchema(this.getClass()
					.getClassLoader().getResource(SPARK_CONFIG_LOCATION));

			jContext = JAXBContext
					.newInstance("org.sparkeasy.web.config");
			unmarshaller = jContext.createUnmarshaller();
			unmarshaller.setSchema(sparkWebSchema);
			JAXBElement<SparkeasyConfig> jElement = (JAXBElement<SparkeasyConfig>) unmarshaller
					.unmarshal(new FileInputStream(new File(contextPath)));
			SparkeasyConfig config = jElement.getValue();
			context = MetadataContext.getInstance();
			context.initialize(config);
		} catch (SAXException | JAXBException | FileNotFoundException e) {
			e.printStackTrace();
			throw new MetadataNotInitializedException(
					"Unable to load the configuration", e);
		}
		return context;
	}
}
