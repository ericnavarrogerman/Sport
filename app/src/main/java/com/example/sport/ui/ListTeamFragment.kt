package com.example.sport.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.sport.R
import com.example.sport.mvvm.ViewModelListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTeamFragment : Fragment() {


    val model :ViewModelListFragment by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list_team, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        model.getTeamsForLeague("Soccer","Spain")
        model.teams.observe(viewLifecycleOwner,{

          var cantidad=  it.size
        })
    }

}