package com.tessaro.loterica.exceptionhandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NegocioException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public NegocioException(String msg) {
		super(msg);
	}
	public NegocioException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
