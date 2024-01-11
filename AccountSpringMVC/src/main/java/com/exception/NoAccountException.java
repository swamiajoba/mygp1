package com.exception;

import java.util.Arrays;

public class NoAccountException extends Exception{
	public NoAccountException() {
		// TODO Auto-generated constructor stub
	}
	public NoAccountException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	@Override
	public String toString() {
		return "NoAccountException [getMessage()=" + getMessage() + ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + ", toString()=" + "]";
	}
	
}
