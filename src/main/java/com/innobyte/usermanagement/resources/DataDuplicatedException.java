package com.innobyte.usermanagement.resources;

import lombok.Getter;

public class DataDuplicatedException extends Exception {

	private static final long serialVersionUID = -563350727145153884L;

	private static final String DEFAULT_MESSAGE = "No se pudo guardar el dato";

	@Getter
	private final String message;

	public DataDuplicatedException() {
		super(DEFAULT_MESSAGE);
		this.message=DEFAULT_MESSAGE;
	}

	public DataDuplicatedException(String message) {
		super(message);
		this.message = message;
	}

	public DataDuplicatedException(Exception e) {
		super(DEFAULT_MESSAGE, e);
		this.message=DEFAULT_MESSAGE;
	}

	public DataDuplicatedException(String message, Exception e) {
		super(message, e);
		this.message = message;
	}

}
