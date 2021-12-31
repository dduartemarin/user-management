package com.innobyte.usermanagement.resources;

import lombok.Getter;

public class DataNotSavedException extends Exception {
	private static final long serialVersionUID = -2386978218099632947L;

	private static final String DEFAULT_MESSAGE = "No se pudo guardar el dato";

	@Getter
	private final String message;

	public DataNotSavedException() {
		super(DEFAULT_MESSAGE);
		this.message=DEFAULT_MESSAGE;
	}

	public DataNotSavedException(String message) {
		super(message);
		this.message = message;
	}

	public DataNotSavedException(Exception e) {
		super(DEFAULT_MESSAGE, e);
		this.message=DEFAULT_MESSAGE;
	}

	public DataNotSavedException(String message, Exception e) {
		super(message, e);
		this.message = message;
	}

}