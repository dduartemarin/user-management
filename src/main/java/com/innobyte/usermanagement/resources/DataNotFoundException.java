package com.innobyte.usermanagement.resources;

import lombok.Getter;

public class DataNotFoundException extends Exception {
	private static final long serialVersionUID = -1720068124541066045L;
	private static final String DEFAULT_MESSAGE = "No se encontraron datos para la consulta";

	@Getter
	private final String message;

	public DataNotFoundException() {
		super(DEFAULT_MESSAGE);
		this.message=DEFAULT_MESSAGE;
	}

	public DataNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public DataNotFoundException(Exception e) {
		super(DEFAULT_MESSAGE, e);
		this.message=DEFAULT_MESSAGE;
	}

	public DataNotFoundException(String message, Exception e) {
		super(message, e);
		this.message = message;
	}

}