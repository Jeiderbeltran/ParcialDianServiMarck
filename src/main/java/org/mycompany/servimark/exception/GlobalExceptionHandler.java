package org.mycompany.servimark.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Obtiene el mensaje de error de la excepción
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        
        // Construye la respuesta con el mensaje de error
        ErrorResponse errorResponse = new ErrorResponse("Validation Error", errorMessage);
        
        // Devuelve la respuesta con el código de estado 400 (Bad Request)
        return ResponseEntity.badRequest().body(errorResponse);
    }

    // Clase para representar la respuesta de error
    static class ErrorResponse {
        private final String error;
        private final String message;

        public ErrorResponse(String error, String message) {
            this.error = error;
            this.message = message;
        }

        public String getError() {
            return error;
        }

        public String getMessage() {
            return message;
        }
    }
}

