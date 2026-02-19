// package com.demoproject.Config;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import com.demoproject.DTO.ApiResponse;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<ApiResponse> handleException(Exception ex) {
//         return ResponseEntity
//                 .status(HttpStatus.BAD_REQUEST)
//                 .body(new ApiResponse(false, ex.getMessage(), null));
//     }
// }
