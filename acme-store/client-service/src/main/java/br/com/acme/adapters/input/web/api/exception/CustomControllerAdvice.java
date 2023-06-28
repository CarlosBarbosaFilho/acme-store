package br.com.acme.adapters.input.web.api.exception;

import br.com.acme.adapters.input.web.api.exception.errors.ApiErrorsResponse;
import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ClientNotFundException.class)
    public ResponseEntity<ApiErrorsResponse> handleClientNotFundException(
            ClientNotFundException exception, WebRequest webRequest
    ) {
        var dataError = ApiErrorsResponse.DataMessageError
                .builder()
                .description("client not found")
                .date_time(LocalDateTime.now())
                .status_code(HttpStatus.NOT_FOUND.value())
                .message("Client search not found")
                .build();

        var apiError = ApiErrorsResponse.builder()
                .data_message_error(dataError)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<ApiErrorsResponse>(apiError, HttpStatus.NOT_FOUND);
    }
}
