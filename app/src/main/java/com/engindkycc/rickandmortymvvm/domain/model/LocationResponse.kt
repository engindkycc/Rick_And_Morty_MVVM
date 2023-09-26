package com.engindkycc.rickandmortymvvm.domain.model

data class LocationResponse(
    val info: Info,
    val results: ArrayList<Location>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
