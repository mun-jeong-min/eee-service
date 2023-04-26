package com.example.eeeservice.domain.practice.present

import com.example.eeeservice.domain.practice.present.dto.CreatePracticeRequest
import com.example.eeeservice.domain.practice.present.dto.ReadPracticeRequest
import com.example.eeeservice.domain.practice.service.CreatePracticeService
import com.example.eeeservice.domain.practice.service.ReadPracticeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/practice")
class PracticeController (
        private val createPracticeService: CreatePracticeService,
        private val readPracticeService: ReadPracticeService
) {

    @PostMapping
    fun create(@RequestBody request: CreatePracticeRequest) {
        createPracticeService.execute(request)
    }

    @GetMapping
    fun read(@RequestBody request: ReadPracticeRequest) {
        readPracticeService.execute(request)
    }
}