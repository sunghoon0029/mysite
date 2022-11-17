package com.bitacademy.mysite.exception;

public class UserRepositoryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserRepositoryException() {
		super("UserDaoException Occurs");
	}
	
	public UserRepositoryException(String message) {
		super(message);
	}
}
