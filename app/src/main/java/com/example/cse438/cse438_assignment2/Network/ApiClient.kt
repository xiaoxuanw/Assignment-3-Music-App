package com.example.cse438.cse438_assignment2.Network


import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    const val BASE_URL = "https://deezer.com/"
    fun makeRetrofitService(): TrackInterface {
       return Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(MoshiConverterFactory.create())
           .build().create(TrackInterface::class.java)

    }

}