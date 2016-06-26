package com.wedevol.util;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

public class Util {

	public static final int OK_CODE = 200;
	public static final int ERROR_CODE = 500;
	public static final String OK_MESSAGE = "OK";
	public static final String ERROR_MESSAGE = "ERROR";

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
}
