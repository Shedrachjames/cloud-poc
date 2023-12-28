package com.NorrenCloud.CloudPoc.models;

public class ApiResponse {
	private Object response;
	protected Object statusCode;
	
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public Object getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Object statusCode) {
		this.statusCode = statusCode;
	}
	public ApiResponse(Object response, Object statusCode) {
		super();
		this.response = response;
		this.statusCode = statusCode;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ApiResponse [response=" + response + ", statusCode=" + statusCode + "]";
	}
	
	
}
