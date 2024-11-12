package com.example.pruebaxd.util.manejoErrores.exception;


import  com.example.pruebaxd.util.apiResponse.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
private ResponseUtil responseUtil=new ResponseUtil();
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        String status = HttpStatus.METHOD_NOT_ALLOWED.toString();
        String errorMessage = "Method Not Allowed";
        String details = ex.getMessage();
        return responseUtil.getExceptionGlobal(status, errorMessage, details);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        String  status = HttpStatus.INTERNAL_SERVER_ERROR.toString();
        String errorMessage = "Internal Server Error";
        String details = ex.getMessage();
        return responseUtil.getExceptionGlobal(status, errorMessage, details);
    }

}
