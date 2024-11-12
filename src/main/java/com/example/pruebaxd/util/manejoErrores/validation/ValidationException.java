package com.example.pruebaxd.util.manejoErrores.validation;



import org.springframework.http.HttpStatus;


public class ValidationException extends RuntimeException  {

	private static final long serialVersionUID = -7388451699730601469L;
	private final HttpStatus status;

	public ValidationException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}


	public static <T> boolean exceptionTrue(boolean lanzarExection,String mensaje ) {
		if (lanzarExection) {
			throw new ValidationException(mensaje,HttpStatus.BAD_REQUEST);

		}
		return false;
	}




}
