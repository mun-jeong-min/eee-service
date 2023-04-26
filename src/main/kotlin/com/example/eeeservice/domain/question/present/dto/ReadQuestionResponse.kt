package com.example.eeeservice.domain.question.present.dto

import java.time.LocalDateTime

data class ReadQuestionResponse (
        val content: String,
        val createAt: LocalDateTime
)
