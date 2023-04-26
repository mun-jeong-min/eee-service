package com.example.eeeservice.domain.question.domain.repository

import com.example.eeeservice.domain.question.domain.Question
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : CrudRepository<Question, Long> {
    override fun findAll(): List<Question>
}