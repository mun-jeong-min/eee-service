package com.example.eeeservice.global.error

import com.example.eeeservice.global.error.custom.CustomException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionFilter {

    @ExceptionHandler(CustomException::class)
    fun of(e: CustomException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
                ErrorResponse.of(e), HttpStatus.valueOf(e.status)
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun valid(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
                ErrorResponse.valid(400, "Bad Request"), HttpStatus.valueOf(400)
        )
    }
}