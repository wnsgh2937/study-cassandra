package org.example.studycassandra

import org.springframework.data.repository.CrudRepository

interface LeoRepository : CrudRepository<LeoEntity, String> {
}