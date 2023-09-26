package com.engindkycc.rickandmortymvvm.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(

    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: CharacterOrigin,
    val location: CharacterLocation,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created:String


): Parcelable

@Parcelize
data class CharacterOrigin(

    val name : String ,
    val url : String

): Parcelable

@Parcelize
data class CharacterLocation(

    val name: String ,
    val url: String

):Parcelable

/*@Parcelize
data class CharacterEpisode(

    val episode: ArrayList<String>

) : Parcelable*/



