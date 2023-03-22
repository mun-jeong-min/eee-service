package com.example.eeeservice.domain.practice.domain.repository

import com.example.eeeservice.domain.practice.domain.Practice
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PracticeRepository : CrudRepository<Practice, Long> {
}