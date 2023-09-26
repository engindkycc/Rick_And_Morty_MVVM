package com.engindkycc.rickandmortymvvm.domain.repository

import androidx.paging.PagingData
import com.engindkycc.rickandmortymvvm.data.remote.dto.CharacterDto
import com.engindkycc.rickandmortymvvm.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepoInterface {

    fun getLocationList(): Flow<PagingData<Location>>

    suspend fun getAllCharacter(characters: String): List<CharacterDto>
}