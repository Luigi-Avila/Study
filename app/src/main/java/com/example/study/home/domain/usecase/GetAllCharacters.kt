package com.example.study.home.domain.usecase

import com.example.study.home.data.HomeRepositoryImp
import com.example.study.home.domain.HomeRepository

class GetAllCharacters {
    private val repository = HomeRepositoryImp()
    suspend fun getAllCharactersUseCase() = repository.getAllCharacters()
}