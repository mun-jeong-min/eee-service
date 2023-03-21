package com.example.eeeservice.domain.practice.domain.repository

import com.example.eeeservice.domain.practice.domain.Practice
import org.springframework.data.repository.CrudRepository

interface PracticeRepository : CrudRepository<Practice, Long> {
}