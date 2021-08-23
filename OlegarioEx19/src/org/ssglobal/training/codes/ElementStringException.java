package org.ssglobal.training.codes;

@SuppressWarnings("serial")
public class ElementStringException extends Exception{
	
	private String message = "Invalid element value: [String]";
	
	public ElementStringException() {}
	
	public ElementStringException(String newMessage) {
		message = newMessage;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void printStackTrace() {
		System.err.println(message);
	} 

}
