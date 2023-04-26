package com.example.eeeservice.domain.question.present

import com.example.eeeservice.domain.question.present.dto.CreateQuestionRequest
import com.example.eeeservice.domain.question.present.dto.ReadQuestionListResponse
import com.example.eeeservice.domain.question.service.CreateQuestionService
import com.example.eeeservice.domain.question.service.ReadQuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/question")
class QuestionController (
        private val createQuestionService: CreateQuestionService,
        private val readQuestionService: ReadQuestionService
) {

    @PostMapping
    fun create(@RequestBody request: CreateQuestionRequest) {
        createQuestionService.execute(request)
    }

    @GetMapping
    fun read(): ReadQuestionListResponse {
        return readQuestionService.execute()
    }
}