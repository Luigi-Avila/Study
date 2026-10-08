package com.example.study.home.data

import com.example.study.home.core.network.Network
import com.example.study.home.core.network.toCharacter
import com.example.study.home.data.network.Characters
import com.example.study.home.domain.Character
import com.example.study.home.domain.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepositoryImp : HomeRepository {
    private val retrofit = Network.getRetrofit()
    override suspend fun getAllCharacters(): List<Character> {
        val listCharacter = mutableListOf<Character>()
        return withContext(Dispatchers.IO) {
            retrofit.create(Characters::class.java).getAllCharacters()
                .body()?.results?.forEach { character ->
                    println("for each --> $character")
                    listCharacter.add(character.toCharacter())
                }
            listCharacter
        }
    }
}