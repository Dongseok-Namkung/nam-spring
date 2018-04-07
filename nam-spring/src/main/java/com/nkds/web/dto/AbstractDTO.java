package com.nkds.web.dto;

import org.springframework.http.HttpStatus;

public class AbstractDTO {
	private HttpStatus httpStatus;
	private String result;
	
	public AbstractDTO() {
		httpStatus = HttpStatus.OK;
		result = "Result is not empty.";
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public AbstractDTO setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		
		return this;
	}

	public String getResult() {
		return result;
	}

	public AbstractDTO setResult(String result) {
		this.result = result;
		
		return this;
	}
	
	
}
