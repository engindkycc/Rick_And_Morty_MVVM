package com.engindkycc.rickandmortymvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.engindkycc.rickandmortymvvm.presentation.character_list.CharacterState
import com.engindkycc.rickandmortymvvm.domain.use_case.get_character.GetCharacterUseCase
import com.engindkycc.rickandmortymvvm.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val getCharacterUseCase: GetCharacterUseCase) : ViewModel() {

    private val _state = MutableLiveData<CharacterState>()
    val state : LiveData<CharacterState> get() = _state


    fun getCharacterData(characterUrlList : List<String>?) {

        var characterList = ""

        characterUrlList?.map {
            characterList += (it.substring(it.lastIndexOf("/") + 1) + ",")
        }
        characterList.removeSuffix(",")

        if (characterList.isNotEmpty())
            fetchData(characterList)
        else
            _state.value = CharacterState(isEmpty = true)
    }

    private fun fetchData(characterList : String) {
        getCharacterUseCase(characterList).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharacterState(characters = result.data ?: arrayListOf())
                }

                is Resource.Loading  -> {

                    _state.value = CharacterState(isLoading = true)
                }
                is Resource.Error -> {

                    _state.value = CharacterState(error = result.message ?: "Error !")
                }


                /*is Resource.Loading -> {
                    _state.value = CharacterState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CharacterState(error = result.message ?: "Error !")
                }*/
            }
        }.launchIn(viewModelScope)
    }

}