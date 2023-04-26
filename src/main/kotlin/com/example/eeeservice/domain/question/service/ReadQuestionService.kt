package com.example.eeeservice.domain.question.service

import com.example.eeeservice.domain.question.domain.repository.QuestionRepository
import com.example.eeeservice.domain.question.present.dto.ReadQuestionListResponse
import com.example.eeeservice.domain.question.present.dto.ReadQuestionResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class ReadQuestionService (
        private val questionRepository: QuestionRepository
) {

    @Transactional(readOnly = true)
    fun execute(): ReadQuestionListResponse {
        val questions = questionRepository.findAll().stream()
                .map {
                    ReadQuestionResponse(
                            it.content,
                            it.createdAt
                    )
                }.collect(Collectors.toList())

        return ReadQuestionListResponse(
                questions
        )
    }
}