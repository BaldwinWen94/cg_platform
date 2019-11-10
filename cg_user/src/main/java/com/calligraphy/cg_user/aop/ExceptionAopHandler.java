package com.calligraphy.cg_user.aop;

import com.calligraphy.common.util.HttpUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAopHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleCommonException(Exception e) {
        e.printStackTrace();
        return HttpUtil.serviceError(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity handleParameterException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        return HttpUtil.parameterError(e);
    }
}
