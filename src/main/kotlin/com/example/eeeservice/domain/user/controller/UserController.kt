package com.example.eeeservice.domain.user.controller

import com.example.eeeservice.domain.user.exception.EmailNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping
    fun get(): String {
        throw EmailNotFoundException.EXCEPTION
    }

}