package com.filmstar.application.shared;

public class ErrorResponse {
  Integer code;
  String message;
  
  public ErrorResponse() {
	  
  }
  
  public ErrorResponse(Integer code, String message) {
	  this.code = code;
	  this.message = message;
  }

	public Integer getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
  
  
}
