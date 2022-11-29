package com.hello.springboothello.exceptions;

import com.hello.springboothello.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 注意： 当@ResponseStatus有reason属性，返回值不做处理，而是直接返回服务器自带的error页面
    //      交互体验比较差，建议不要使用
    @ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED)
    @ExceptionHandler({BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
//    public ResponseEntity<ExceptionData> handleParamVerifyException(@NotNull Exception ex) {
    public ResponseResult<ExceptionData> handleParamVerifyException(@NotNull Exception ex) {
        ExceptionData.ExceptionDataBuilder exBuilder = ExceptionData.builder();
        log.warn("Exception: {}", ex.getMessage());
        if (ex instanceof BindException) {
            BindingResult bindingResult = ((BindException) ex).getBindingResult();
            bindingResult.getAllErrors().forEach(e ->
                    exBuilder.error(((FieldError) e).getField() + ":" + e.getDefaultMessage()));
        } else if (ex instanceof ConstraintViolationException) {
            if (ex.getMessage() != null) {
                exBuilder.error(ex.getMessage());
            }
        } else {
            exBuilder.error("invalid parameter");
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Custom-Header", "foo");
//        return new ResponseEntity<>(exBuilder.build(), headers, HttpStatus.BAD_REQUEST)/*ResponseEntity.of(Optional.of(exBuilder.build()))*/;
        return ResponseResult.fail(exBuilder.build(), "invalid parameter");
    }
}
