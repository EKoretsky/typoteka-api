package com.typoteka.api.category

import com.typoteka.api.category.dto.request.CreateCategoryRequest
import com.typoteka.api.category.dto.response.CategoryResponse
import com.typoteka.api.category.exception.CategoryNotFoundException
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun getCategories(): List<CategoryResponse> {
        return categoryRepository
            .findAll()
            .map { it.toDto() }
    }

    fun getCategory(id: Long): CategoryResponse {
        return categoryRepository
            .findById(id)
            .orElseThrow { CategoryNotFoundException(id) }
            .toDto()

    }

    fun createCategory(request: CreateCategoryRequest): CategoryResponse {
        val category = categoryRepository.save(request.toEntity())
        return category.toDto()
    }

    fun deleteCategory(id: Long) {
        categoryRepository.deleteById(id)
    }

}
