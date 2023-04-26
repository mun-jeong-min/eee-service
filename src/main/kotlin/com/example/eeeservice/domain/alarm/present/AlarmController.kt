package com.example.eeeservice.domain.alarm.present

import com.example.eeeservice.domain.alarm.present.dto.ReadAlarmListResponse
import com.example.eeeservice.domain.alarm.service.ReadAlarmService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/alarm")
class AlarmController (
        private val readAlarmService: ReadAlarmService
) {

    @GetMapping
    fun read(): ReadAlarmListResponse {
        return readAlarmService.execute()
    }
}