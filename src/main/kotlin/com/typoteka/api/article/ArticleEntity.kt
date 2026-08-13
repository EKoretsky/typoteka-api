package com.typoteka.api.article

import com.typoteka.api.category.CategoryEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import org.hibernate.annotations.Generated
import java.time.Instant

@Entity
@Table(name = "articles")
class ArticleEntity private constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "announce", nullable = false)
    var announce: String,

    @Column(name = "full_text", nullable = false)
    var fullText: String,

    @ManyToMany
    @JoinTable(
        name = "article_categories",
        joinColumns = [
            JoinColumn(name = "article_id")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "category_id")
        ],
    )
    var categories: MutableSet<CategoryEntity>,

    @Generated
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false,
        insertable = false,
    )
    var createdAt: Instant?
) {
    constructor(
        title: String,
        announce: String,
        fullText: String,
        categories: Set<CategoryEntity>  = emptySet(),
    ) : this(
        id = null,
        title = title,
        announce = announce,
        fullText = fullText,
        categories = categories.toMutableSet(),
        createdAt = null,
    )
}