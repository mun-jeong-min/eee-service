package com.example.eeeservice.domain.practice.present.dto

import java.time.LocalDateTime

data class ReadElement(
        val content: String,
        val createdAt: LocalDateTime,
        val category: String
)
