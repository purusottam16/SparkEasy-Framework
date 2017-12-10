package org.sparkeasy.spi.exception;

public class MetadataNotInitializedException extends RuntimeException {

	public MetadataNotInitializedException() {
		super();
	}

	public MetadataNotInitializedException(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MetadataNotInitializedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MetadataNotInitializedException(String arg0) {
		super(arg0);
	}

	public MetadataNotInitializedException(Throwable arg0) {
		super(arg0);
	}

}
