package com.example.testnote.data.remote.retrofit

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
class RetrofitModule @Inject constructor() {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("mongodb://localhost:27017/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}