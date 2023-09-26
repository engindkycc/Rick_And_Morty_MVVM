package com.engindkycc.rickandmortymvvm.presentation.character_list


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.engindkycc.rickandmortymvvm.R
import com.engindkycc.rickandmortymvvm.databinding.CharacterItemRowFemaleBinding
import com.engindkycc.rickandmortymvvm.databinding.CharacterItemRowMaleBinding
import com.engindkycc.rickandmortymvvm.domain.model.Character
import com.engindkycc.rickandmortymvvm.view.HomeFragmentDirections
import java.lang.IllegalArgumentException

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private var characterList : ArrayList<Character> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        return when(viewType){

            R.layout.character_item_row_male -> CharacterViewHolder.MaleViewHolder(
                CharacterItemRowMaleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.character_item_row_female -> CharacterViewHolder.FemaleViewHolder(
                CharacterItemRowFemaleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid ViewType Provider")
        }
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

    when(holder){

        is CharacterViewHolder.MaleViewHolder -> holder.bind(characterList[position])
        is CharacterViewHolder.FemaleViewHolder -> holder.bind(characterList[position])

    }

    holder.itemView.setOnClickListener {

        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(characterList[position])
        Navigation.findNavController(it).navigate(action)
    }


    }

    override fun getItemCount(): Int {

        return characterList.size

    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateCharacterList(newCharacterList : ArrayList<Character>){

        characterList.clear()
        characterList.addAll(newCharacterList)
        notifyDataSetChanged()


    }

    override fun getItemViewType(position: Int): Int {
        if (characterList[position].gender == "Female" || characterList[position].gender == "unknown")
            return R.layout.character_item_row_female
        if (characterList[position].gender == "Male" || characterList[position].gender == "Genderless")
            return R.layout.character_item_row_male
        else
            return R.layout.character_item_row_male
    }
}