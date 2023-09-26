package com.engindkycc.rickandmortymvvm.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
//import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.engindkycc.rickandmortymvvm.presentation.character_list.CharacterAdapter
import com.engindkycc.rickandmortymvvm.presentation.location_list.LocationAdapter
import com.engindkycc.rickandmortymvvm.databinding.FragmentHomeBinding
import com.engindkycc.rickandmortymvvm.viewmodel.CharacterViewModel
import com.engindkycc.rickandmortymvvm.viewmodel.LocationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var locationAdapter: LocationAdapter
    private lateinit var characterAdapter: CharacterAdapter
    private val locationviewModel: LocationViewModel by viewModels()
    private val characterviewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Dark Mode Disable
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()

        binding.apply {

            //LocationAdapter setup
            locationAdapter = LocationAdapter()
            locationRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            locationRecyclerView.adapter = locationAdapter

            //CharacterAdapter setup
            characterAdapter = CharacterAdapter()
            characterRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            characterRecyclerView.adapter  = characterAdapter

            //Location list
            lifecycleScope.launch {

                locationviewModel.getLocationStream().collectLatest {

                    locationAdapter.submitData(it)
                }

            }

            //Bringing characters when clicking on the location
            locationAdapter.onItemClickedListener = {

                lifecycleScope.launch {

                   characterviewModel.getCharacterData(it.residents)
                }

            }

        }

    }

    private fun observeLiveData() {
        binding.apply {

            characterviewModel.state.observe(viewLifecycleOwner) { characters ->
                characters?.let {

                    characterAdapter.updateCharacterList(it.characters)
                }

            }

        }

    }

}




