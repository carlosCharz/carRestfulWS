package com.wedevol.exception;

import com.wedevol.util.Util;

public class CarNotFoundException extends ErrorException {

	private static final long serialVersionUID = 1L;

	public CarNotFoundException() {
		super(Util.NOT_FOUND_ERROR_CODE, Util.NOT_FOUND_ERROR_MESSAGE);
	}

	public CarNotFoundException(String message) {
		super(Util.NOT_FOUND_ERROR_CODE, message);
	}

	public CarNotFoundException(int code, String message) {
		super(code, message);
	}

}
