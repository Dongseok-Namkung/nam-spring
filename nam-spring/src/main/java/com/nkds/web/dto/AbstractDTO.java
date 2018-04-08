package com.nkds.web.dto;

import org.springframework.http.HttpStatus;

public class AbstractDTO {
	private HttpStatus httpStatus;
	
	public AbstractDTO() {
		httpStatus = HttpStatus.OK;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public AbstractDTO setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		
		return this;
	}

}
