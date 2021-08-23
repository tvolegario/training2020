package org.ssglobal.training.codes;

@SuppressWarnings("serial")
public class BadIndexException extends Exception{
	
	private String message = "Bad Index";
	
	public BadIndexException() {}
	
	public BadIndexException(String newMessage) {
		message = newMessage;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void printStackTrace() {
		System.err.println(message);
	} 
	
}
