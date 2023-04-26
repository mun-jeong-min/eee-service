package com.example.eeeservice.domain.question.service

import com.example.eeeservice.domain.question.domain.Question
import com.example.eeeservice.domain.question.domain.repository.QuestionRepository
import com.example.eeeservice.domain.question.present.dto.CreateQuestionRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateQuestionService (
        private val questionRepository: QuestionRepository
) {

    @Transactional
    fun execute(request: CreateQuestionRequest) {
        questionRepository.save(
                Question(
                        request.content
                )
        )
    }
}