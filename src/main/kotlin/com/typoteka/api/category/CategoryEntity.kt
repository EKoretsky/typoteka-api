package com.typoteka.api.category

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "categories")
class CategoryEntity private constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "name",nullable = false)
    var name: String,
) {
    constructor(name: String) : this(
        name = name,
        id = null
    )
}