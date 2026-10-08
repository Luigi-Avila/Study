package com.example.study.home.data.model

data class ResponseDAO(
    val info: InfoDAO,
    val results: List<ResultDAO>
)