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




    val progressIsVisible= MutableLiveData<Boolean>()
    val errorIsVisible= MutableLiveData<Boolean>()
    val reciclerIsVisible= MutableLiveData<Boolean>()

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        errorIsVisible.postValue(true)
        progressIsVisible.postValue(false)

    }

    private val _teams=MutableLiveData<List<Teams>>()

    val teams:LiveData<List<Teams>>
    get() =_teams

    fun getTeamsForLeague(idLeague:String){

        reciclerIsVisible.value=false
        errorIsVisible.value=false
        progressIsVisible.value=true


        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {

           val response= repository.getTeamsForLeague(idLeague)

            if (response.isSuccessful){

                 errorIsVisible.postValue(false)
                 progressIsVisible.postValue(false)

                 reciclerIsVisible.postValue(true)

                _teams.postValue(response.body()!!.teams)

            }else{
                 errorIsVisible.postValue(true)
                 progressIsVisible.postValue(false)
            }

        }

    }

}
