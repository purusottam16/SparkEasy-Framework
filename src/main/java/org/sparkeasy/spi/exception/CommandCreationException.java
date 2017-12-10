package org.sparkeasy.spi.exception;

public class CommandCreationException extends RuntimeException {

	public CommandCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandCreationException(String message) {
		super(message);
	}

}
