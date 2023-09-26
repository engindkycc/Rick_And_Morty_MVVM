package com.engindkycc.rickandmortymvvm.presentation.character_list

import com.engindkycc.rickandmortymvvm.domain.model.Character

data class CharacterState(

    val isLoading : Boolean = false,
    val characters : ArrayList<Character> = arrayListOf(),
    val error : String = "",
    val isEmpty : Boolean = false
)
