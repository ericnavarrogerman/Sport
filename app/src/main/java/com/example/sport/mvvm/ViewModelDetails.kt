package com.example.sport.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sport.model.Events
import com.example.sport.model.Teams
import com.example.sport.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ViewModelDetails  @Inject constructor( val repository: Repository): ViewModel() {



    private val _events= MutableLiveData<List<Events>>()


    val events: LiveData<List<Events>>
        get() =_events



    fun getEventForIdTeam(id:String){

        repository.getEventForIdTeam(id)

        repository._events.observeForever({
            _events.value=it
        })
    }


}