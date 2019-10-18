package com.example.retrofit.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InitRetrofit {

    fun getIniRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(EndPoints.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    }

    fun getInitInstance(): ApiService{
        return getIniRetrofit().create(ApiService::class.java)
    }

}