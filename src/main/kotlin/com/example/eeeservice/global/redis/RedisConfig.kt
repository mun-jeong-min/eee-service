package com.example.eeeservice.global.redis

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

@Configuration
class RedisConfig (
        private val redisProperties: RedisProperties
) {

    @Bean
    fun connect(): RedisConnectionFactory {
        return LettuceConnectionFactory(
                redisProperties.host,
                redisProperties.port
        )
    }
}