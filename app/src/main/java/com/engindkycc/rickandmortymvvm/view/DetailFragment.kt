package com.engindkycc.rickandmortymvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.engindkycc.rickandmortymvvm.R
import com.engindkycc.rickandmortymvvm.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args by navArgs<DetailFragmentArgs>()
    private var _binding : FragmentDetailBinding ?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Definitions
        var episodes: String
        val episodeList = arrayListOf<String>()

        binding.apply {

            //Character photo setup
            Glide.with(this@DetailFragment).load(args.currentCharacter.image).into(detailImageView)

            //Transferring character information to texts
            detailTitleTextView.text = args.currentCharacter.name
            detailStatusTextView.text = args.currentCharacter.status
            detailSpecyTextView.text = args.currentCharacter.species
            detailGenderTextView.text = args.currentCharacter.gender
            detailOrignTextView.text = args.currentCharacter.origin.name
            detailLocationTextView.text = args.currentCharacter.location.name

            //Extracting character parts and adding them to the list
            args.currentCharacter.episode.map {

                val episode = it.substring(it.lastIndexOf("/")+1)
                episodeList.add(episode)

            }

            //Transferring character episode to text
            episodes = episodeList.joinToString(",")
            detailEpisodeTextView.text = episodes

            //Returning to the page
            backButton.setOnClickListener {

                findNavController().popBackStack()

            }

        }

    }

}