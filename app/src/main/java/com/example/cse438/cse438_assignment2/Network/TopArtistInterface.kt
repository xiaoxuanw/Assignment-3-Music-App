package com.example.cse438.cse438_assignment2.Network

import com.example.cse438.cse438_assignment2.Data.Chart
import com.example.cse438.cse438_assignment2.Data.ChartArtist
import com.example.cse438.cse438_assignment2.Data.Data
import com.example.cse438.cse438_assignment2.Data.Track
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.lang.reflect.Array

interface TopArtistInterface {
    public val artistID: Int
    //Search by parameters
    @GET("search")
    suspend fun getArtistBySearchQuery(@Query("q") query: String)
            : Response<Data>

    @GET("chart/0/artists")
    suspend fun getArtistByChart()
            : Response<ChartArtist>

    @GET("artist/")
    suspend fun getArtistByArtistID(@Path("") path: String)
            : Response<ChartArtist>
}