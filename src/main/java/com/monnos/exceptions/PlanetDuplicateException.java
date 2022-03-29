package com.monnos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PlanetDuplicateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlanetDuplicateException() {
		super("Duplicate entry, already has another planet with the same characteristics");
	}
}
