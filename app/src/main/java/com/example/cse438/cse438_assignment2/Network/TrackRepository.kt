package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.Track

class TrackRepository {
    //get the instance of retrofit
    val service = ApiClient.makeRetrofitService()

    //searches for breweries based on string value
    fun getTrackBySearch(resBody : MutableLiveData<List<Track>>, param : String, byCity: Boolean) {

    }
}