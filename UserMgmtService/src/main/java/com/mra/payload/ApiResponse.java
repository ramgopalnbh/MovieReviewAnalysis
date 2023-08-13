package com.mra.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse {
    private String msg;
    private Boolean success;
    private HttpStatus status;
}
