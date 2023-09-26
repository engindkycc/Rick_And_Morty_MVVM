package com.engindkycc.rickandmortymvvm.data.remote

import com.engindkycc.rickandmortymvvm.data.remote.dto.CharacterDto
import com.engindkycc.rickandmortymvvm.domain.model.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.engindkycc.rickandmortymvvm.common.Constants.LOCATION_END_POINT
import retrofit2.http.Path

interface ApiService {

    @GET(LOCATION_END_POINT)
    suspend fun getLocation(@Query("page") page : Int) : Response<LocationResponse>

    @GET("character/{characters}")
    suspend fun getCharacter(@Path("characters") characters : String) : List<CharacterDto>
}