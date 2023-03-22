package com.example.eeeservice.domain.user.exception

import com.example.eeeservice.global.error.custom.CustomException
import com.example.eeeservice.global.error.custom.ErrorCode

object EmailNotFoundException : CustomException(ErrorCode.EMAIL_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = EmailNotFoundException
}