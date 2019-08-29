package org.radix.network2.addressbook;

public class AddressBookException extends RuntimeException {
	private static final long serialVersionUID = 1010470947697889845L;

	public AddressBookException(String msg) {
		super(msg);
	}

	public AddressBookException(String msg, Exception cause) {
		super(msg, cause);
	}

}
