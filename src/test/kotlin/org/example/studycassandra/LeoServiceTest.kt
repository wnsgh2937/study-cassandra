package org.example.studycassandra

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LeoServiceTest @Autowired constructor(
    private val leoRepository: LeoRepository
) {

    @Test
    fun insertTest01() {
        val leoEntity = LeoEntity(
            name = "Leo",
            age = 30,
            specialties = setOf("Java", "Kotlin", "Spring")
        )
        leoEntity.id = "leo01"
        val entity = leoRepository.save(leoEntity)
        println(entity.id)
    }
}