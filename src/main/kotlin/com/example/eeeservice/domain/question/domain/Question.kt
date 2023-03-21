package com.example.eeeservice.domain.question.domain

import com.example.eeeservice.global.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_question")
class Question (

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(200)")
        val content: String

) : BaseEntity()