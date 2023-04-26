package com.example.eeeservice.domain.practice.service

import com.example.eeeservice.domain.alarm.domain.Alarm
import com.example.eeeservice.domain.alarm.domain.repository.AlarmRepository
import com.example.eeeservice.domain.practice.domain.Practice
import com.example.eeeservice.domain.practice.domain.category.Category
import com.example.eeeservice.domain.practice.domain.repository.PracticeRepository
import com.example.eeeservice.domain.practice.present.dto.CreatePracticeRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreatePracticeService (
        private val practiceRepository: PracticeRepository,
        private val alarmRepository: AlarmRepository
) {

    @Transactional
    fun execute(request: CreatePracticeRequest) {
        practiceRepository.save(
                Practice(
                        content = request.content,
                        category = Category.valueOf(request.category)
                )
        )
        alarmRepository.save(
                Alarm(
                        request.content
                )
        )
    }

}