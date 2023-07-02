package br.com.acme.application.domain.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorsResponse {
    private HttpStatus status;
    private DataMessageError details;
    private List<FieldErrorResponse> fields_required;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DataMessageError{
        private int status_code;
        private String message;
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
        private LocalDateTime date_time;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class FieldErrorResponse {
        private  String message;
        private  String field;
        private  Object parameter;
    }
}
