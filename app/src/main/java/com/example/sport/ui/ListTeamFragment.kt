package com.example.sport.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHost
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.sport.R
import com.example.sport.databinding.FragmentListTeamBinding
import com.example.sport.model.Teams
import com.example.sport.mvvm.ViewModelListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTeamFragment : Fragment() {


    val model :ViewModelListFragment by viewModels()
    lateinit var  binding:FragmentListTeamBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentListTeamBinding.bind(inflater.inflate(R.layout.fragment_list_team,container,false))




        context?.let { ArrayAdapter.createFromResource(it,R.array.leagues, android.R.layout.simple_spinner_item).also { 
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter=adapter
            binding.spinner.onItemSelectedListener = object :OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    val selected = parent?.getItemAtPosition(position).toString().split(" ").get(0)
                    model.getTeamsForLeague(selected)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

        } }


        val adapter = AdapterTeams().apply {
            clic={  team ->

                val accion =ListTeamFragmentDirections.actionListTeamFragmentToDetailsTeamFragment(team)

                findNavController().navigate(accion)
            }
        }

        val decoration: RecyclerView.ItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        binding.rvTeams.apply {
            this.adapter=adapter
            addItemDecoration(decoration)

        }


        model.teams.observe(viewLifecycleOwner,{

            adapter.setDataList(ArrayList(it))

        })


        return binding.root
    }


}