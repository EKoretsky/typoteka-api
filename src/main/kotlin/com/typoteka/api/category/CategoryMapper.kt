package com.typoteka.api.category

import com.typoteka.api.category.dto.request.CreateCategoryRequest
import com.typoteka.api.category.dto.response.CategoryResponse

fun CreateCategoryRequest.toEntity() = CategoryEntity(
    name = name,
)


fun CategoryEntity.toDto() = CategoryResponse(
    id = checkNotNull(id),
    name = name,
)