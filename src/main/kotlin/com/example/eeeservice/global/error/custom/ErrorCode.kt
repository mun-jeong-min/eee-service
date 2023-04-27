package com.example.eeeservice.global.error.custom

import org.springframework.http.HttpStatus

enum class ErrorCode (
        val status: HttpStatus,
        val message: String
) {

    USER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다.");
}