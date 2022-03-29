package com.monnos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class MissingPlanetAttributesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MissingPlanetAttributesException() {
		super("Missing required planet fields");
	}
}
