package com.typoteka.api.article.dto.response

import com.typoteka.api.category.dto.response.CategoryResponse
import java.time.Instant

data class ArticleResponse(
    val id: Long,
    val title: String,
    val announce: String,
    val fullText: String,
    val categories: Set<CategoryResponse>,
    val createdAt: Instant,
)