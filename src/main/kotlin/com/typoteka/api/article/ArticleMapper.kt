package com.typoteka.api.article

import com.typoteka.api.article.dto.request.CreateArticleRequest
import com.typoteka.api.article.dto.response.ArticleResponse
import com.typoteka.api.category.CategoryEntity
import com.typoteka.api.category.toDto

fun CreateArticleRequest.toEntity(
    categories: Set<CategoryEntity> = emptySet(),
) = ArticleEntity(
    title = title,
    announce = announce,
    fullText = fullText,
    categories = categories
)


fun ArticleEntity.toResponse() = ArticleResponse(
    id = checkNotNull(id),
    title = title,
    announce = announce,
    fullText = fullText,
    categories = categories
        .map { it.toDto() }
        .toSet(),
    createdAt = checkNotNull(createdAt)
)