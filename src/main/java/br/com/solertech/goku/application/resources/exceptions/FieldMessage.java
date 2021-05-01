package br.com.solertech.goku.application.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{

	private static final long serialVersionUID = 1115981561760654304L;

	private String fieldMessage;
	private String message;
	
	
	
	public FieldMessage() {
		super();
	}
	
	public FieldMessage(String fieldMessage, String message) {
		super();
		this.fieldMessage = fieldMessage;
		this.message = message;
	}
	public String getFieldMessage() {
		return fieldMessage;
	}
	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
