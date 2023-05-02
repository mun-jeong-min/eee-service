package com.example.eeeservice.domain.practice.service

import com.example.eeeservice.domain.practice.domain.category.Category
import com.example.eeeservice.domain.practice.present.dto.ReadAllCategory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AllCategoryService {

    @Transactional
    fun read(): ReadAllCategory {
        val iterator = Category.values().iterator()
        val list: MutableList<String> = mutableListOf()

        while (iterator.hasNext()) {
            list.add(iterator.next().name)
        }

        return ReadAllCategory(
                list
        )
    }
}