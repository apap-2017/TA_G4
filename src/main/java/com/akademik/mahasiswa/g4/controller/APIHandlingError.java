package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.rest.BaseResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class APIHandlingError {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public BaseResponseModel requestHandlingNoHandlerFound() {
        return new BaseResponseModel(404,"Not found", null);
    }

}
