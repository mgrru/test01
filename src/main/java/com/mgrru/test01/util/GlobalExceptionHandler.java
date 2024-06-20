package com.mgrru.test01.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public R<String> runtime(NoResourceFoundException e){
        log.error(e.getMessage());
        return R.error(codeEnums.NOT_FOUND);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public R<String> runtime(RuntimeException e){
        log.error(e.getMessage());
        return R.error(codeEnums.RUN_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public R<String> exception(Exception e){
        log.error(e.getMessage());
        return R.error(codeEnums.UN_ERROR);
    }
}
