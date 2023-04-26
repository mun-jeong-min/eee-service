package com.example.eeeservice.domain.practice.service

import com.example.eeeservice.domain.practice.domain.category.Category
import com.example.eeeservice.domain.practice.domain.repository.PracticeRepository
import com.example.eeeservice.domain.practice.present.dto.ReadElement
import com.example.eeeservice.domain.practice.present.dto.ReadPracticeRequest
import com.example.eeeservice.domain.practice.present.dto.ReadPracticeResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class ReadPracticeService (
        private val practiceRepository: PracticeRepository
) {

    @Transactional(readOnly = true)
    fun execute(request: ReadPracticeRequest): ReadPracticeResponse {
        val list = practiceRepository.findAllByCategory(Category.valueOf(request.category))
                .stream()
                .map {
                    ReadElement(
                            it.content,
                            it.createdAt,
                            it.category.name
                    )
                }.collect(Collectors.toList())

        return ReadPracticeResponse(
                list
        )
    }

}