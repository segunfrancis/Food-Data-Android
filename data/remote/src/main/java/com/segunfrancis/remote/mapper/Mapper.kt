package com.segunfrancis.remote.mapper

interface Mapper<R, D> {
    fun mapRemoteToDomain(data: R): D
}
