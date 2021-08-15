package com.example.sport.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.sport.R
import com.example.sport.databinding.FragmentDetailsTeamBinding
import com.example.sport.model.Teams


class DetailsTeamFragment : Fragment() {



    val args : DetailsTeamFragmentArgs by navArgs()


    lateinit var binding :FragmentDetailsTeamBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentDetailsTeamBinding.bind(inflater.inflate(R.layout.fragment_details_team,container,false))


        binding.team = args.team




        return binding.root
    }

}