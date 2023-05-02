package com.example.eeeservice.domain.practice.present

import com.example.eeeservice.domain.practice.present.dto.*
import com.example.eeeservice.domain.practice.service.AllCategoryService
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
        private val readPracticeService: ReadPracticeService,
        private val allCategoryService: AllCategoryService
) {

    @PostMapping
    fun create(@RequestBody request: CreatePracticeRequest) {
        createPracticeService.execute(request)
    }

    @PostMapping("/category")
    fun add(@RequestBody request: CategoryRequest) {
        createPracticeService.add(request)
    }

    @PostMapping("/read")
    fun read(@RequestBody request: ReadPracticeRequest): ReadPracticeResponse {
        return readPracticeService.execute(request)
    }

    @GetMapping
    fun readAll(): ReadAllCategory {
        return allCategoryService.read()
    }
}