package br.com.solertech.goku.application.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4336909357605735367L;

	public ObjectNotFoundException(String message) {
		super(message);
	}
}
