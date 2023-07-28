package br.com.acme.adapters.input.web.api.exception;

import br.com.acme.application.domain.exception.ApiErrorsResponse;
import br.com.acme.application.domain.exception.ClientNotFundException;
import br.com.acme.application.domain.exception.EmailClientExistsException;
import br.com.acme.application.domain.exception.ErrorLoginClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ErrorLoginClientException.class)
    public ResponseEntity<ApiErrorsResponse> handleErrorLoginClientException(ErrorLoginClientException exception,
                                                                          WebRequest webRequest) {
        var dataError = ApiErrorsResponse.DataMessageError
                .builder()
                .description("Error to login")
                .date_time(LocalDateTime.now())
                .status_code(HttpStatus.BAD_REQUEST.value())
                .message("Email or password is invalid")
                .build();

        var apiError = ApiErrorsResponse.builder()
                .fields_required(new ArrayList<>())
                .details(dataError)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<ApiErrorsResponse>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFundException.class)
    public ResponseEntity<ApiErrorsResponse> handleClientNotFundException(ClientNotFundException exception,
                                                                      WebRequest webRequest) {
        var dataError = ApiErrorsResponse.DataMessageError
                .builder()
                .description("client not found")
                .date_time(LocalDateTime.now())
                .status_code(HttpStatus.NOT_FOUND.value())
                .message("Client search not found")
                .build();

        var apiError = ApiErrorsResponse.builder()
                .fields_required(new ArrayList<>())
                .details(dataError)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<ApiErrorsResponse>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorsResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                          WebRequest webRequest) {
        var fieldsError = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    return ApiErrorsResponse.FieldErrorResponse.builder()
                            .parameter(fieldError.getDefaultMessage())
                            .field(fieldError.getField())
                            .message("This field is required")
                            .build();
                }).toList();

        var dataError = ApiErrorsResponse.DataMessageError
                .builder()
                .description("Invalid field to this request")
                .date_time(LocalDateTime.now())
                .status_code(HttpStatus.BAD_REQUEST.value())
                .message("Fields is required to request")
                .build();

        var apiError = ApiErrorsResponse.builder()
                .details(dataError)
                .fields_required(fieldsError)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<ApiErrorsResponse>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailClientExistsException.class)
    public ResponseEntity<ApiErrorsResponse> handleEmailClientExistsException(EmailClientExistsException exception,
                                                                              WebRequest webRequest) {
        var dataError = ApiErrorsResponse.DataMessageError
                .builder()
                .description("E-mail already exists")
                .date_time(LocalDateTime.now())
                .status_code(HttpStatus.CONFLICT.value())
                .message("Client not save, e-mail already exists")
                .build();

        var apiError = ApiErrorsResponse.builder()
                .fields_required(new ArrayList<>())
                .details(dataError)
                .status(HttpStatus.CONFLICT)
                .build();

        return new ResponseEntity<ApiErrorsResponse>(apiError, HttpStatus.CONFLICT);
    }
}
