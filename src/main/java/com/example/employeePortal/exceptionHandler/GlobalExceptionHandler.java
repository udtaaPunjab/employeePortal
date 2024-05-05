package com.example.employeePortal.exceptionHandler;

import com.example.employeePortal.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.employeePortal.errorResponse.ErrorResponse;

import java.time.LocalTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
       ErrorResponse  errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(), LocalTime.now().toString());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
