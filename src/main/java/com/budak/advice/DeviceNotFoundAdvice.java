package com.budak.advice;

import com.budak.netaschallenge.exception.DeviceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Samet BUDAK
 * @since
 */
@ControllerAdvice
public class DeviceNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DeviceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String deviceNotFoundHandler(DeviceNotFoundException ex) {
        return ex.getMessage();
    }
}
