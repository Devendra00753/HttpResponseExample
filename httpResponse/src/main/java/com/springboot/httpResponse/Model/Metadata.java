package com.springboot.httpResponse.Model;

public class Metadata {
	
	private int status;
	private String message;
	private String next;
	public Metadata(int status, String message, String next) {
		this.status=status;
		this.message=message;
		this.next=next;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "httpMetadata [status=" + status + ", message=" + message + ", next=" + next + "]";
	}
	
	
}
