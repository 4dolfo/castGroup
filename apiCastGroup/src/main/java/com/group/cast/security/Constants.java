package com.group.cast.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String OPEN_URL = "/open/**";
	public static final String H2_CONSOLE = "/h2-console/**";
	
	public static final Integer NU_ROUNDS=12;
	
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer";
	
	// JWT

	public static final String ISSUER_INFO = "https://www.autentia.com/";
	public static final String SUPER_SECRET_KEY = "CU17UR4";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
}
