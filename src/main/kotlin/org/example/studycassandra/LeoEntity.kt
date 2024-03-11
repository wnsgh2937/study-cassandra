package org.example.studycassandra

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table
class LeoEntity(
    val name: String,
    val age: Int,
    val specialties: Set<String>
) {

    @PrimaryKey
    var id: String? = null

}