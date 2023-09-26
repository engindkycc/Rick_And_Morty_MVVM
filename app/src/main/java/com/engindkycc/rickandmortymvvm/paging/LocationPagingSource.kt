package com.engindkycc.rickandmortymvvm.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.engindkycc.rickandmortymvvm.data.remote.ApiService
import com.engindkycc.rickandmortymvvm.domain.model.Location

class LocationPagingSource(private val apiService: ApiService) : PagingSource<Int , Location>() {

    override fun getRefreshKey(state: PagingState<Int, Location>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Location> {

        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getLocation(currentPage)
            val responseData = mutableListOf<Location>()
            val data =  response.body()?.results?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if(currentPage == 1) null else - 1,
                nextKey = currentPage.plus(1)
            )
        }catch (e : Exception) {

            LoadResult.Error(e)
        }
    }
}
