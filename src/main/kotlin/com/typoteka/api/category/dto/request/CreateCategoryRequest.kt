package com.typoteka.api.category.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateCategoryRequest(
    @field:NotBlank(message = "Name must not be blank")
    @field:Size(min = 2, max = 20, message = "Content must be between 2 and 20 characters")
    val name: String,
)
