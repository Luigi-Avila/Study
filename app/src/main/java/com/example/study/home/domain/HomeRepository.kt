package com.example.study.home.domain

interface HomeRepository {
    suspend fun getAllCharacters(): List<Character>
}