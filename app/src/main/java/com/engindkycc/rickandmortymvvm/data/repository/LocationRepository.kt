package com.engindkycc.rickandmortymvvm.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.engindkycc.rickandmortymvvm.data.remote.ApiService
import com.engindkycc.rickandmortymvvm.data.remote.dto.CharacterDto
import com.engindkycc.rickandmortymvvm.domain.model.Location
import com.engindkycc.rickandmortymvvm.paging.LocationPagingSource
import com.engindkycc.rickandmortymvvm.domain.repository.LocationRepoInterface
import com.engindkycc.rickandmortymvvm.common.Constants.LOCATION_PAGE_ITEM_LIMIT
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepository @Inject constructor(private val apiService: ApiService) :
    LocationRepoInterface {

    override fun getLocationList(): Flow<PagingData<Location>> {

        return Pager(

         config = PagingConfig(LOCATION_PAGE_ITEM_LIMIT, enablePlaceholders = false) ,
         pagingSourceFactory = {LocationPagingSource(apiService)}
        ).flow
    }

     override suspend fun getAllCharacter(characters: String): List<CharacterDto> {
        return apiService.getCharacter(characters)
    }


}