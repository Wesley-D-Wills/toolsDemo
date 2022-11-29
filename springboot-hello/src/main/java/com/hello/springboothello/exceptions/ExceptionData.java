package com.hello.springboothello.exceptions;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class ExceptionData {
    @Singular
    private final List<Object> errors;
}
