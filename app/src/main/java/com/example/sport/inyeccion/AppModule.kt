package com.example.sport.inyeccion

import com.example.sport.repository.Repository
import com.example.sport.service.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun apiProvider():ApiClient= ApiClient()


    @Provides
    @Singleton
    fun repositoryProvider():Repository= Repository(ApiClient())

}