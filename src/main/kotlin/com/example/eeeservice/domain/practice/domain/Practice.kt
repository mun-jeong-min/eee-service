package com.example.eeeservice.domain.practice.domain

import com.example.eeeservice.domain.practice.domain.category.Category
import com.example.eeeservice.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_practice")
class Practice (

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(200)")
        val content: String,

        @field:Enumerated(EnumType.STRING)
        @field:NotNull
        val category: Category

) : BaseEntity()