package com.engindkycc.rickandmortymvvm.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(

    val id : Int ,
    val name : String ,
    val residents: ArrayList<String>

) : Parcelable
