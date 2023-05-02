package com.example.eeeservice.domain.user.domain.repository

import com.example.eeeservice.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findUserByEmail(email: String): User?

    override fun findAll(): List<User>
}