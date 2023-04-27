package com.example.eeeservice.domain.user.controller

import com.example.eeeservice.domain.user.controller.dto.CodeRequest
import com.example.eeeservice.domain.user.controller.dto.EmailRequest
import com.example.eeeservice.domain.user.service.UserAuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
        private val userAuthService: UserAuthService
) {

    @PostMapping
    fun get(@RequestBody request: EmailRequest) {
        userAuthService.execute(request)
    }

    @PostMapping("/signup")
    fun code(@RequestBody request: CodeRequest):String {
        return userAuthService.signup(request)
    }

}