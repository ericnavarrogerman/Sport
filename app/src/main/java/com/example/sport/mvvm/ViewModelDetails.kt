package com.example.sport.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sport.model.Events
import com.example.sport.model.ResponseEvents
import com.example.sport.model.Teams
import com.example.sport.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ViewModelDetails  @Inject constructor( val repository: Repository): ViewModel() {

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _error.postValue(throwable.message)
    }


    private val _events= MutableLiveData<List<Events>>()

    val events: LiveData<List<Events>>
        get() =_events


    private val _error =MutableLiveData<String>()

    val error :LiveData<String>
        get() = _error


    fun getEventForIdTeam(id:String) {


        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = repository.getEventForIdTeam(id)
            if (response.isSuccessful){
                _events.postValue(response.body()!!.events)
            }else{
               _error.postValue(response.message())
            }

        }

    }
}