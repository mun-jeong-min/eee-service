package com.example.eeeservice.domain.alarm.domain.repository

import com.example.eeeservice.domain.alarm.domain.Alarm
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AlarmRepository : CrudRepository<Alarm, Long> {
}