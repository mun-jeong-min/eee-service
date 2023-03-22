package com.example.eeeservice.global.error

import com.example.eeeservice.global.error.custom.CustomException

class ErrorResponse (
        val status: Int,
        val message: String
) {
    companion object {
        fun of(e: CustomException): ErrorResponse = ErrorResponse(
                status = e.status,
                message = e.errorMessage
        )

        fun valid(status: Int, message: String): ErrorResponse = ErrorResponse(
                status = status,
                message = message
        )

        }
}