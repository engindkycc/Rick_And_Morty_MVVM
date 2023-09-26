package com.engindkycc.rickandmortymvvm.domain.use_case.get_character


import com.engindkycc.rickandmortymvvm.domain.model.Character
import com.engindkycc.rickandmortymvvm.common.Resource
import com.engindkycc.rickandmortymvvm.data.remote.dto.toCharacter
import com.engindkycc.rickandmortymvvm.domain.repository.LocationRepoInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject


class GetCharacterUseCase @Inject constructor(private val repository: LocationRepoInterface)  {


    operator fun invoke(characters : String) : Flow<Resource<ArrayList<Character>>> = flow {
        try {
            emit(Resource.Loading())
            val characterList = repository.getAllCharacter(characters).map { it.toCharacter()}
            val characterArrayList = ArrayList(characterList)
            emit(Resource.Success(characterArrayList))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage))
        }
    }


}