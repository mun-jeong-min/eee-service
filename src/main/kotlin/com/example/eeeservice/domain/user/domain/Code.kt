package com.example.eeeservice.domain.user.domain

import com.example.eeeservice.global.entity.BaseEntity
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class Code (

        @field:Id
        val code: Int,

        @field:Indexed
        val email: String,

        @field:TimeToLive
        val timeToLive: Long
        
)