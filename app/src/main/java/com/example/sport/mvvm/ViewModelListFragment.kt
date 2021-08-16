package com.example.sport.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sport.model.ResponseApi
import com.example.sport.model.Teams
import com.example.sport.repository.Repository
import com.example.sport.service.ApiClient
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ViewModelListFragment @Inject constructor(var repository: Repository): ViewModel() {


    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _error.postValue(throwable.message)
    }

    private val _teams=MutableLiveData<List<Teams>>()

    val teams:LiveData<List<Teams>>
    get() =_teams

    private val _error =MutableLiveData<String>()

    val error :LiveData<String>
        get() = _error




    fun getTeamsForLeague(idLeague:String){


        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {

           val response= repository.getTeamsForLeague(idLeague)

            if (response.isSuccessful){
                _teams.postValue(response.body()!!.teams)
            }else{
                _error.postValue(response.message())
            }

        }






    }

}
