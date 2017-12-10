package org.sparkeasy.spi.exception;

public class ForwardNotAvailableException extends RuntimeException {

	public ForwardNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ForwardNotAvailableException(String message) {
		super(message);
	}

}
