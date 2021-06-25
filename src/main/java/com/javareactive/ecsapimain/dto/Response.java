package com.javareactive.ecsapimain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private T data;
    private String message;
    private HttpStatus httpcode;
}
