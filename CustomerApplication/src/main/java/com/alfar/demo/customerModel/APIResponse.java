package com.alfar.demo.customerModel;

public class APIResponse {

	public Integer statusCode;
	public String message;
	public AccessToken accessToken;

	public APIResponse() {
		super();
	}

	public APIResponse(Integer statusCode, String message, AccessToken accessToken) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.accessToken = accessToken;
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the accessToken
	 */
	public AccessToken getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}
}