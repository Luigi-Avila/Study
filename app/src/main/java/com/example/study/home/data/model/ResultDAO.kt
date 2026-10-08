package com.example.study.home.data.model

data class ResultDAO(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDAO,
    val name: String,
    val origin: OriginDAO,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)