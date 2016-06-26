package com.wedevol.util;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

public class Util {

	public static final int OK_CODE = 200;
	public static final int NOT_FOUND_ERROR_CODE = 404;
	public static final int SERVER_ERROR_CODE = 500;
	public static final String OK_MESSAGE = "OK";
	public static final String SERVER_ERROR_MESSAGE = "Server Error: Handling 500 error on a car entry";
	public static final String NOT_FOUND_ERROR_MESSAGE = "Not Found Error: Handling 404 error on a car entry";
	public static final String ERROR_LABEL = "ERROR ---> ";
	public static final String OK_LABEL = "OK --->";
	public static final String JSON_RESPONSE_LABEL = "JSON RESPONSE ---> ";

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
}
