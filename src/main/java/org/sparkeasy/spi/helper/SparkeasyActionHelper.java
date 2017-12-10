package org.sparkeasy.spi.helper;

import org.sparkeasy.spi.config.MetadataContext;
import org.sparkeasy.spi.exception.CommandCreationException;
import org.sparkeasy.web.command.SparkeasyAction;

public class SparkeasyActionHelper {
	public static SparkeasyAction getSparkeasyAction(String action) {
		MetadataContext metadataContext = null;
		SparkeasyAction sparkeasyAction = null;
		String commandClass = null;

		metadataContext = MetadataContext.getInstance();
		commandClass = metadataContext.getCommandClass(action);
		try {
			sparkeasyAction = (SparkeasyAction) Class.forName(commandClass)
					.newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new CommandCreationException(
					"error while creating command object", e);
		}

		return sparkeasyAction;
	}
}
