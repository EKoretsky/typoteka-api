package com.typoteka.api.article.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class CreateArticleRequest(
    @field:NotBlank(message = "Name must not be blank")
    @field:Size(min = 5, max = 100, message = "Content must be between 5 and 100 characters")
    val title: String,
    @field:NotBlank(message = "Name must not be blank")
    @field:Size(min = 5, max = 250, message = "Content must be between 5 and 250 characters")
    val announce: String,
    @field:NotBlank(message = "Name must not be blank")
    val fullText: String,
    @field:NotEmpty(message = "Category IDs must not be empty")
    val categoryIds: Set<Long>
)
