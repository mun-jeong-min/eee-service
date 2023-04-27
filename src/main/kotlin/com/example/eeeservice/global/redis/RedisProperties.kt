package com.example.eeeservice.global.redis

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "spring.redis")
@ConstructorBinding
class RedisProperties (
        val host: String,
        val port: Int
)