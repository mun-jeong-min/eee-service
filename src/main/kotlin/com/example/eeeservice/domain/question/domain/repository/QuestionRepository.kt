package com.example.eeeservice.domain.question.domain.repository

import com.example.eeeservice.domain.question.domain.Question
import org.springframework.data.repository.CrudRepository

interface QuestionRepository : CrudRepository<Question, Long> {
}