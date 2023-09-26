package com.engindkycc.rickandmortymvvm.viewmodel

import androidx.paging.cachedIn
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.engindkycc.rickandmortymvvm.domain.model.Location
import com.engindkycc.rickandmortymvvm.data.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class LocationViewModel  @Inject  constructor( private val repository: LocationRepository) : ViewModel(){

    fun getLocationStream() : Flow<PagingData<Location>> {

        return repository.getLocationList().cachedIn(viewModelScope)
    }


}