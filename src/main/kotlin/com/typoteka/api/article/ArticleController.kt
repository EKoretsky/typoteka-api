package com.typoteka.api.article

import com.typoteka.api.article.dto.request.CreateArticleRequest
import com.typoteka.api.article.dto.response.ArticleResponse
import com.typoteka.api.category.dto.request.CreateCategoryRequest
import com.typoteka.api.category.dto.response.CategoryResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RestController
@RequestMapping("/articles")
class ArticleController(
    private val articleService: ArticleService
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getArticles(): List<ArticleResponse> {
        return articleService.getArticles()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getArticle(
        @PathVariable("id") id: Long
    ): Unit {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createArticle(
        @Validated @RequestBody request: CreateArticleRequest
    ): Unit {
        articleService.createArticle(request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteArticle(
        @PathVariable("id") id: Long
    ) {
    }
}
