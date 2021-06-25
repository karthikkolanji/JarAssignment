package com.example.photos.di

import com.example.photos.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
class DataModule{

    @Provides
    @FragmentScoped
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}