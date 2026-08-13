package com.typoteka.api.common.exception

abstract class NotFoundException(
    override val message: String,
    val code: String = "NOT_FOUND",
) : RuntimeException(message)