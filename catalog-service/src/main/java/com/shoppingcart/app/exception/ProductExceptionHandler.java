package com.shoppingcart.app.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * For study purpose:
 * 
 * ControllerAdvice -> It's continuously listening the application.
 * If an exception is thrown it will search this class for the specific handle for 
 * the exception.
 */

@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler{

	private static final String NOT_NULL = "NotNull";
	private static final String NOT_BLANK = "NotBlank";
	private static final String LENGTH = "Length";

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error> errors = generateErrorsList(ex.getBindingResult());
		
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	private List<Error> generateErrorsList(BindingResult bindingResult) {
		List<Error> errors = new ArrayList<>();
		bindingResult.getFieldErrors().forEach(fieldError -> {
			String msgUser = userErrorMessage(fieldError);
			String msgDev = fieldError.toString();
			errors.add(new Error(msgUser, msgDev));
		});
		
		return errors;
	}
	
	private String userErrorMessage(FieldError fieldError) {
		if(fieldError.getCode().equals(NOT_BLANK)) {
			return fieldError.getDefaultMessage().concat(" is required.");
		}
		if(fieldError.getCode().equals(LENGTH)) {
			return fieldError.getDefaultMessage()
					.concat(String.format(" should have at least %s and a maximum of %s characters",
							fieldError.getArguments()[2], fieldError.getArguments()[1]));
		}
		if(fieldError.getCode().equals(NOT_NULL)) {
			return fieldError.getDefaultMessage().concat(" is required.");
		}
		return fieldError.toString();
	}
}
