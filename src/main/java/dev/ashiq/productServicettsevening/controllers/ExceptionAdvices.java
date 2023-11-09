package dev.ashiq.productServicettsevening.controllers;

import dev.ashiq.productServicettsevening.Exception.NotFoundException;
import dev.ashiq.productServicettsevening.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFound(Exception exception){
       ErrorResponseDto errorResponseDto = new ErrorResponseDto();
       errorResponseDto.setErrorMessage(exception.getMessage());
       return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);

    }
}
