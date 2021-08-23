package org.ssglobal.training.codes;

@SuppressWarnings("serial")
public class ElementDecimalException extends Exception {
	
	private String message = "Invalid element value: [floating-point]";
	
	public ElementDecimalException() {}
	
	public ElementDecimalException(String newMessage) {
		message = newMessage;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void printStackTrace() {
		System.err.println(message);
	} 

}
