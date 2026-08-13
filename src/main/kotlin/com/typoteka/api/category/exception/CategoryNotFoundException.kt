package com.typoteka.api.category.exception

import com.typoteka.api.common.exception.NotFoundException

class CategoryNotFoundException(
    id: Long,
) : NotFoundException(
    message = "Category with ID $id not found",
)