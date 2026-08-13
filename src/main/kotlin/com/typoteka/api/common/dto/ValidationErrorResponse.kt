package com.typoteka.api.common.dto

import org.springframework.web.bind.MethodArgumentNotValidException

@ConsistentCopyVisibility
data class ValidationErrorResponse private constructor(
    val code: String,
    val message: String,
    val errors: Map<String, List<String>>,
) {
    constructor(errors: Map<String, List<String>>) : this(
        code = "VALIDATION_ERROR",
        message = "Validation failed",
        errors = errors,
    )
}