package com.example.cse438.cse438_assignment2.Network

import com.example.cse438.cse438_assignment2.Data.Track
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackInterface {
    //@GET("api_category.php")
    //suspend fun getCategories(): Response<CategoryPayload>

    //@GET("api.php")
    //suspend fun getQuestionsBySearch(@Query("category") category: String, @Query("amount") amount: String) : Response<Payload>

    //Search by parameters
    @GET("search")
    suspend fun getTrackBySearch(@Query("q") query: String)
            : Response<List<Track>>
}