package com.example.cse438.cse438_assignment2.Network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.LocalDateTime

object ApiArtistClient {
    const val BASE_URL = "https://api.deezer.com/"
    fun makeRetrofitService(): TopArtistInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(TopArtistInterface::class.java)

    }

}