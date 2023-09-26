package com.engindkycc.rickandmortymvvm.data.remote.dto

import com.engindkycc.rickandmortymvvm.domain.model.Character
import com.engindkycc.rickandmortymvvm.domain.model.CharacterLocation
import com.engindkycc.rickandmortymvvm.domain.model.CharacterOrigin

data class CharacterDto(

    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    val location: CharacterLocation,
    val origin: CharacterOrigin


)

fun CharacterDto.toCharacter() : Character {

    return Character(

        id = id,
        name = name,
        image = image,
        status = status,
        species = species,
        gender = gender,
        origin = origin,
        location = location,
        episode = episode,
        created = created,
        url = url


    )


}
