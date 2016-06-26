package com.wedevol.exception;

import com.wedevol.util.Util;

public class CarServerErrorException extends ErrorException {

	private static final long serialVersionUID = 1L;

	public CarServerErrorException() {
		super(Util.SERVER_ERROR_CODE, Util.SERVER_ERROR_MESSAGE);
	}

	public CarServerErrorException(String message) {
		super(Util.SERVER_ERROR_CODE, message);
	}

	public CarServerErrorException(int code, String message) {
		super(code, message);
	}

}
