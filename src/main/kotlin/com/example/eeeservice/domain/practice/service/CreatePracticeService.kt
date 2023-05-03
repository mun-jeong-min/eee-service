package com.example.eeeservice.domain.practice.service

import com.example.eeeservice.domain.alarm.domain.Alarm
import com.example.eeeservice.domain.alarm.domain.repository.AlarmRepository
import com.example.eeeservice.domain.practice.domain.Practice
import com.example.eeeservice.domain.practice.domain.category.Category
import com.example.eeeservice.domain.practice.domain.repository.PracticeRepository
import com.example.eeeservice.domain.practice.present.dto.CategoryRequest
import com.example.eeeservice.domain.practice.present.dto.CreatePracticeRequest
import com.example.eeeservice.domain.question.domain.Question
import com.example.eeeservice.domain.question.domain.repository.QuestionRepository
import com.example.eeeservice.domain.user.domain.repository.UserRepository
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreatePracticeService (
        private val practiceRepository: PracticeRepository,
        private val alarmRepository: AlarmRepository,
        private val questionRepository: QuestionRepository,
        private val sender: JavaMailSender,
        private val userRepository: UserRepository
) {

    @Transactional
    fun execute(request: CreatePracticeRequest) {
        val category = Category.valueOf(request.category)

        practiceRepository.save(
                Practice(
                        content = request.content,
                        category
                )
        )
        alarmRepository.save(
                Alarm(
                        "$category 의 행동이 추가되었습니다"
                )
        )

        userRepository.findAll().stream()
                .map {
                    val message = SimpleMailMessage()
                    message.from = "moondeve41@gmail.com"
                    message.setTo(it.email)
                    message.subject = "운동하세요 - EEE-SERVICE"
                    message.text = "$category 의 행동이 추가되었습니다"
                    sender.send(message)
                }
    }

    @Transactional
    fun add(request: CategoryRequest) {
        questionRepository.save(
                Question(
                        request.category + "추가해주세요"
                )
        )
    }

}