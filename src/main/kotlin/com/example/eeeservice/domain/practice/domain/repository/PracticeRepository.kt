package com.example.eeeservice.domain.practice.domain.repository

import com.example.eeeservice.domain.practice.domain.Practice
import com.example.eeeservice.domain.practice.domain.category.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PracticeRepository : CrudRepository<Practice, Long> {
    fun findAllByCategory(category: Category): List<Practice>
}