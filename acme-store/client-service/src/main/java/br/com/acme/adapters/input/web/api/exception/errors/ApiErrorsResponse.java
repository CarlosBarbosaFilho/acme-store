package br.com.acme.adapters.input.web.api.exception.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorsResponse {
    private HttpStatus status;
    private DataMessageError dataMessageErrorr;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DataMessageError{
        private int statusCode;
        private String message;
        private LocalDateTime localDateTime;
        private String description;
    }
}
