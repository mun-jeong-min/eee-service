package com.example.eeeservice.global.error.custom

open class CustomException (
        private val errorCode: ErrorCode
) : RuntimeException() {
    val status: Int
        get() = errorCode.status.value()

    val errorMessage: String
        get() = errorCode.message

}