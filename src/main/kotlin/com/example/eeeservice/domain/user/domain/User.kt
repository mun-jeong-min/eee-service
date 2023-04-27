package com.example.eeeservice.domain.user.domain

import com.example.eeeservice.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user")
class User (

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(50)")
        val email: String

) : BaseEntity()