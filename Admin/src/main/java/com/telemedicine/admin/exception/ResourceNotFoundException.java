package com.telemedicine.admin.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;

}
