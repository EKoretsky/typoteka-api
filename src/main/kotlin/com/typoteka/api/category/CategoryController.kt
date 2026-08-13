package com.typoteka.api.category

import com.typoteka.api.category.dto.request.CreateCategoryRequest
import com.typoteka.api.category.dto.response.CategoryResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getCategories(): List<CategoryResponse> {
        return categoryService.getCategories()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCategory(
        @PathVariable("id") id: Long
    ): CategoryResponse {
        return categoryService.getCategory(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCategory(
        @Validated @RequestBody request: CreateCategoryRequest
    ): CategoryResponse {
        return categoryService.createCategory(request)

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(
        @PathVariable("id") id: Long
    ) {
        categoryService.deleteCategory(id)
    }
}