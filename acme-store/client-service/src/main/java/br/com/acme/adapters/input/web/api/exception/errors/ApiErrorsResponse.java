package br.com.acme.adapters.input.web.api.exception.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorsResponse {
    private HttpStatus status;
    private DataMessageError dataMessageError;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DataMessageError{
        private int statusCode;
        private String message;
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
        private LocalDateTime dateTime;
        private String description;
    }
}
