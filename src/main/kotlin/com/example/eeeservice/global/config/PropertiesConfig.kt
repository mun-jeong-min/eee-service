package com.example.eeeservice.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(basePackages = ["com.example.eeeservice"])
@Configuration
class PropertiesConfig {
}