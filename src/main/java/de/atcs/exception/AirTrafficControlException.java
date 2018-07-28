package de.atcs.exception;

import org.springframework.http.HttpStatus;

public class AirTrafficControlException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMsg;
	
	private HttpStatus httpStatus;

	public AirTrafficControlException(String errorMsg, HttpStatus httpStatus) {
		super();
		this.errorMsg = errorMsg;
		this.httpStatus = httpStatus;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	
	
}
