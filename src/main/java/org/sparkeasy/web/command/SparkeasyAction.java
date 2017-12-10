package org.sparkeasy.web.command;

import org.sparkeasy.web.data.ContextObject;

public interface SparkeasyAction {
	String execute(ContextObject contextObject);
}
