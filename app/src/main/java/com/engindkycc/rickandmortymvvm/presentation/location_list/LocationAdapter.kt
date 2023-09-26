package com.engindkycc.rickandmortymvvm.presentation.location_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.engindkycc.rickandmortymvvm.R
import com.engindkycc.rickandmortymvvm.databinding.LocationLayoutBinding
import com.engindkycc.rickandmortymvvm.domain.model.Location
import javax.inject.Inject

class LocationAdapter @Inject constructor(): PagingDataAdapter<Location, LocationAdapter.LocaleViewHolder>(
    diffCallback
) {

    //private var list = ArrayList<String>()
    var selectedPosition = 0
    var prevSelectedPosition = - 1
    var onItemClickedListener  : (location : Location) -> Unit = {}

    inner class LocaleViewHolder(private var binding: LocationLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(location: Location) {

            //binding.locationNameText.text = location.name
            binding.apply {
                locationNameText.text = location.name
            }

            binding.root.setOnClickListener {

                    prevSelectedPosition = selectedPosition
                    selectedPosition = layoutPosition
                    notifyItemChanged(prevSelectedPosition)
                    notifyItemChanged(selectedPosition)
                    onItemClickedListener(location)

            }
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun defaultBackground(){

                binding.locationNameText.background = itemView.context.getDrawable(R.drawable.button_background)
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun selectedBackground(){

                binding.locationNameText.background = itemView.context.getDrawable(R.drawable.selected_background)
        }

    }


    companion object{

        val diffCallback = object : DiffUtil.ItemCallback<Location>(){

            override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
                return  oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
                return  oldItem.id == newItem.id
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): LocaleViewHolder {

        return LocaleViewHolder(LocationLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocaleViewHolder, position: Int) {
        /*val item = items[position]
        holder.bind(item)*/
        /*val currLocale = getItem(position)

        if(currLocale!=null){
            holder.defaultBackground()
            holder.bind(currLocale)
        }*/

        val currLocale = getItem(position)

        if (selectedPosition == 0 && prevSelectedPosition == -1) {
            onItemClickedListener(getItem(selectedPosition)!!)
            prevSelectedPosition = 0

        }
        if(position == selectedPosition)
            holder.selectedBackground()
        else
            holder.defaultBackground()
        holder.bind(currLocale!!)



    }

    /*override fun getItemCount(): Int {

        return items.size
    }*/


}