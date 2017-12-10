package org.sparkeasy.spi.mapper;

import java.util.Map;

import org.sparkeasy.web.data.ContextObject;

public interface Mapper<T> {
	Map<String, String[]> extractData(T request);

	void bindData(ContextObject object, T request);
}
