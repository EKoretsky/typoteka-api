package com.typoteka.api.article

import com.typoteka.api.article.dto.request.CreateArticleRequest
import com.typoteka.api.article.dto.response.ArticleResponse
import com.typoteka.api.category.CategoryRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
    private val categoryRepository: CategoryRepository
) {


    fun getArticles(): List<ArticleResponse> {
        return articleRepository
            .findAll()
            .map { it.toResponse() }
    }

    fun getArticle(id: Long): ArticleResponse {
        return articleRepository
            .findById(id)
            .orElseThrow { RuntimeException("ercerce  eer") }
            .toResponse()
    }

    @Transactional
    fun createArticle(request: CreateArticleRequest): ArticleResponse {
        val categories = categoryRepository
            .findAllById(request.categoryIds)
            .toSet()

        if (categories.size != request.categoryIds.size) {
            throw RuntimeException("There are ${categories.size} categories")
        }

        val article = request.toEntity(categories)
        return articleRepository
            .save(article)
            .toResponse()

    }
}