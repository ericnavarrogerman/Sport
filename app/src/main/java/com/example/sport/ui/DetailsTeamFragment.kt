package com.example.sport.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sport.R
import com.example.sport.databinding.FragmentDetailsTeamBinding
import com.example.sport.model.Teams
import com.example.sport.mvvm.ViewModelDetails
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsTeamFragment : Fragment() {



    val args : DetailsTeamFragmentArgs by navArgs()

    val model :ViewModelDetails by viewModels()

    lateinit var binding :FragmentDetailsTeamBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentDetailsTeamBinding.bind(inflater.inflate(R.layout.fragment_details_team,container,false))


        binding.team = args.team

        val team:Teams=args.team

        val adapter =AdapterEvents()
        val decoration: RecyclerView.ItemDecoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
        var layoutManager =LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)


        binding.eventos.apply {
            this.adapter=adapter
            this.layoutManager=layoutManager
            addItemDecoration(decoration)

        }

        getEvents(team.id)


        model.events.observe(viewLifecycleOwner,{
            binding.progress=false
            binding.noWifi=false
            binding.recycler=true
            adapter.setDataList(ArrayList(it))
        })

        model.error.observe(viewLifecycleOwner,{
            binding.progress=false
            binding.noWifi=true
            binding.recycler=false
        })

        binding.buttonRetry.setOnClickListener { getEvents(team.id) }

        return binding.root
    }



    fun getEvents(id:String){
        binding.progress=true
        binding.noWifi=false
        binding.recycler=false
        model.getEventForIdTeam(id)
    }

}