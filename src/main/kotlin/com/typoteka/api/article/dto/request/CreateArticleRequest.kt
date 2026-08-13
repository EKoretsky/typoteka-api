package com.typoteka.api.article.dto.request

data class CreateArticleRequest(
    val title: String,
    val announce: String,
    val fullText: String,
    val categoryIds: Set<Long> = emptySet()
)