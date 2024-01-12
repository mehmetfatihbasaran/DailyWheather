package com.example.dailywheather.data.api.mappers

interface ApiMapper<Domain, Entity> {
    fun mapFromEntityToDomain(entity: Entity): Domain
}