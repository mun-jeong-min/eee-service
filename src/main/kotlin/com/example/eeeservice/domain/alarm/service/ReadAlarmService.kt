package com.example.eeeservice.domain.alarm.service

import com.example.eeeservice.domain.alarm.domain.repository.AlarmRepository
import com.example.eeeservice.domain.alarm.present.dto.ReadAlarmListResponse
import com.example.eeeservice.domain.alarm.present.dto.ReadAlarmResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class ReadAlarmService (
        private val alarmRepository: AlarmRepository
) {

    @Transactional(readOnly = true)
    fun execute(): ReadAlarmListResponse {
        val list = alarmRepository.findAll().stream()
                .map {
                    ReadAlarmResponse(
                            it.content,
                            it.createdAt
                    )
                }.collect(Collectors.toList())

        return ReadAlarmListResponse(
                list
        )
    }
}