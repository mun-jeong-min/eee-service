package com.example.eeeservice.domain.user.domain.repository

import com.example.eeeservice.domain.user.domain.Code
import org.springframework.data.repository.CrudRepository

interface CodeRepository : CrudRepository<Code, Int> {
    fun findByEmail(email: String): Code
}