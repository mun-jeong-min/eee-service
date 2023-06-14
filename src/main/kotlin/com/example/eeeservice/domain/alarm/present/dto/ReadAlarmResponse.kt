package com.example.eeeservice.domain.alarm.present.dto

import java.time.LocalDateTime

data class ReadAlarmResponse(
        val content: String,
        val createdAt: String
)
