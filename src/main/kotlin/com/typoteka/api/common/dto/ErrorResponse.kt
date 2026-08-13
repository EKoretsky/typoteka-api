package com.typoteka.api.common.dto

data class ErrorResponse(
    val message: String,
    val code: String,
)