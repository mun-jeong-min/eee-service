package com.example.eeeservice.domain.user.service

import com.example.eeeservice.domain.user.controller.dto.CodeRequest
import com.example.eeeservice.domain.user.controller.dto.EmailRequest
import com.example.eeeservice.domain.user.domain.Code
import com.example.eeeservice.domain.user.domain.User
import com.example.eeeservice.domain.user.domain.repository.CodeRepository
import com.example.eeeservice.domain.user.domain.repository.UserRepository
import com.example.eeeservice.domain.user.exception.UserNotFoundException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Random

@Service
class UserAuthService (
        private val sender: JavaMailSender,
        private val userRepository: UserRepository,
        private val codeRepository: CodeRepository
) {

    @Transactional
    fun execute(request: EmailRequest) {

        val i = (0..999999).random().toString().padStart(999999.toString().length, '0').toInt()

        codeRepository.save(
                Code(
                        i,
                        request.email,
                        180
                )
        )

        val message = SimpleMailMessage()
        message.from = "moondeve41@gmail.com"
        message.setTo(request.email)
        message.subject = "인증코드"
        message.text = i.toString()
        sender.send(message)
    }

    @Transactional
    fun signup(request: CodeRequest):String {
        if(codeRepository.findByEmail(request.email).code == request.code) {
            if(userRepository.findUserByEmail(request.email) == null) {
                userRepository.save(
                        User(
                                request.email
                        )
                )
                return "회원가입 성공"
            }
            return "로그인 성공"
        } else {
            return "인증 실패"
        }
    }
}