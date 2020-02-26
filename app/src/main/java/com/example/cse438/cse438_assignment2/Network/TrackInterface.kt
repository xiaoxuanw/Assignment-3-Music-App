package com.example.cse438.cse438_assignment2.Network

import com.example.cse438.cse438_assignment2.Data.Track
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackInterface {

    //Search by parameters
    @GET("track/search")
    suspend fun getTrackBySearch(@Query("query") query: String)
            : Response<List<Track>>

    @GET("by_Artist")
    suspend fun getTrackByArtist(@Query("by_Artist") by_artist:String)
             :Response<List<Track>>
}