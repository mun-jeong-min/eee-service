package com.example.eeeservice.domain.alarm.domain.repository

import com.example.eeeservice.domain.alarm.domain.Alarm
import org.springframework.data.repository.CrudRepository

interface AlarmRepository : CrudRepository<Alarm, Long> {
}