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
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreatePracticeService (
        private val practiceRepository: PracticeRepository,
        private val alarmRepository: AlarmRepository,
        private val questionRepository: QuestionRepository,
        private val sender: JavaMailSender
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
        val message = SimpleMailMessage()
        message.from = "moondeve41@gmail.com"
        message.setTo("3330kys@dsm.hs.kr")
        message.subject = "인증코드"
        message.text = request.content + "운동이 추가되었습니다."
        sender.send(message)
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