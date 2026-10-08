package com.example.study.home.core.network

import com.example.study.home.data.model.ResponseDAO
import com.example.study.home.data.model.ResultDAO
import com.example.study.home.domain.Character

fun ResultDAO.toCharacter() = Character(name = this.name)