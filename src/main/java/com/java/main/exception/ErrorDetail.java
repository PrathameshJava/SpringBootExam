package com.java.main.exception;

import java.util.Date;

import javax.persistence.Entity;


public class ErrorDetail {

	private String message;
	private String Detail;
	private Date timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public ErrorDetail(String message, String detail, Date timestamp) {
		super();
		this.message = message;
		Detail = detail;
		this.timestamp = timestamp;
	}
}
