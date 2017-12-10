package org.sparkeasy.spi.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sparkeasy.spi.exception.CommandNotFoundException;
import org.sparkeasy.spi.exception.ForwardNotAvailableException;
import org.sparkeasy.spi.exception.MetadataNotInitializedException;
import org.sparkeasy.web.config.CommandMapping;
import org.sparkeasy.web.config.Forward;
import org.sparkeasy.web.config.SparkeasyConfig;

public class MetadataContext {
	private Map<String, CommandMapping> commandMappings;
	private Map<String, String> globalForwards;
	private static MetadataContext instance;

	private MetadataContext() {
		commandMappings = new HashMap<String, CommandMapping>();
		globalForwards = new HashMap<String, String>();
	}

	public static MetadataContext getInstance() {
		if (instance == null) {
			synchronized (MetadataContext.class) {
				if (instance == null) {
					instance = new MetadataContext();
				}
			}
		}
		return instance;
	}

	public void initialize(SparkeasyConfig config) {
		List<CommandMapping> mappings;
		List<Forward> forwards;

		// load global forwards
		forwards = config.getGlobalForwards().getForward();
		for (Forward forward : forwards) {
			this.globalForwards.put(forward.getOutcome(), forward.getView());
		}

		// load command - mappings
		mappings = config.getCommandMappings().getCommandMapping();
		for (CommandMapping mapping : mappings) {
			commandMappings.put(mapping.getAction(), mapping);
		}
	}

	public String getCommandClass(String action) {
		if (commandMappings.size() <= 0) {
			throw new MetadataNotInitializedException("No metadata found");
		}
		if (commandMappings.containsKey(action) == false) {
			throw new CommandNotFoundException(
					"No command mapped for the action");
		}
		return commandMappings.get(action).getCommandClass();
	}

	public String getView(String action, String outcome) {
		CommandMapping mapping = null;
		String view = null;

		if (commandMappings.size() <= 0) {
			throw new MetadataNotInitializedException("No metadata found");
		}
		if (commandMappings.containsKey(action) == false) {
			throw new CommandNotFoundException(
					"No command mapped for the action");
		}
		mapping = commandMappings.get(action);
		for (Forward forward : mapping.getForward()) {
			if (forward.getOutcome().equals(outcome)) {
				view = forward.getView();
				break;
			}
		}
		if (view == null) { // command mapping outcome is not found
			if (globalForwards.containsKey(outcome) == false) {
				throw new ForwardNotAvailableException(
						"No forward mapped for the outcome");
			}
			view = globalForwards.get(outcome);
		}
		return view;
	}
}
