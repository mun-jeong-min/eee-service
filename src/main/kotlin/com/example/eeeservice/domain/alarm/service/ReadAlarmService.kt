package com.example.eeeservice.domain.alarm.service

import com.example.eeeservice.domain.alarm.domain.repository.AlarmRepository
import com.example.eeeservice.domain.alarm.present.dto.ReadAlarmListResponse
import com.example.eeeservice.domain.alarm.present.dto.ReadAlarmResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class ReadAlarmService (
        private val alarmRepository: AlarmRepository
) {

    @Transactional(readOnly = true)
    fun execute(): ReadAlarmListResponse {
        val list = alarmRepository.findAll().stream()
                .map {
                    val date = LocalDateTime.parse(it.createdAt.toString())
                    var minute: String = date.minute.toString()

                    if (date.minute.toString().length == 1) {
                        minute = "0$minute"
                    }

                    val time = date.toLocalDate().toString() + " " +
                            date.hour.toString() + ":" +
                            minute

                    ReadAlarmResponse(
                            it.content,
                            time
                    )
                }.collect(Collectors.toList())

        list.reverse()

        return ReadAlarmListResponse(
                list
        )
    }
}