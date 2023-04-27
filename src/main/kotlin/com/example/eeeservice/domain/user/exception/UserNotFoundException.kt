package com.example.eeeservice.domain.user.exception

import com.example.eeeservice.global.error.custom.CustomException
import com.example.eeeservice.global.error.custom.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = UserNotFoundException
}