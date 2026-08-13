package com.typoteka.api.common.exception

import com.typoteka.api.common.dto.ErrorResponse
import com.typoteka.api.common.dto.ValidationErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(e: NotFoundException): ErrorResponse {
        return ErrorResponse(
            message = e.message,
            code = e.code,
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun onValidationFailed(e: MethodArgumentNotValidException): ValidationErrorResponse {
        val errors = e.bindingResult.fieldErrors.groupBy(
            keySelector = { it.field },
            valueTransform = { it.defaultMessage ?: "Unknown error" }
        )

        return ValidationErrorResponse(errors)
    }
}