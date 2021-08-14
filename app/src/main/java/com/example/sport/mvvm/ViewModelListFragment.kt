package com.example.sport.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sport.model.Teams
import com.example.sport.repository.Repository
import com.example.sport.service.ApiClient
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ViewModelListFragment @Inject constructor(var repository: Repository): ViewModel() {


    private val _teams=MutableLiveData<List<Teams>>()


    val teams:LiveData<List<Teams>>
    get() =_teams



    fun getTeamsForLeague(sport:String,country:String){

        repository.getTeamsForLeague(sport,country)

        repository._teams.observeForever({
            _teams.value=it
        })
    }

}
