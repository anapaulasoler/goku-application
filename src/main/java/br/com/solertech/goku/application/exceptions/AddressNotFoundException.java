package br.com.solertech.goku.application.exceptions;

public class AddressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4441062762500324793L;

	public AddressNotFoundException(String message) {
		super(message);
	}
}
