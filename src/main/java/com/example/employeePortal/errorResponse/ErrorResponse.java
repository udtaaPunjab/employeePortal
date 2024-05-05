package com.example.employeePortal.errorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    public Integer statusCode;
    public String message;
    public String timestamp;
}
