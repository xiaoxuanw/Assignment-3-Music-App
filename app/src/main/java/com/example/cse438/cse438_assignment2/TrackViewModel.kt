package com.example.cse438.cse438_assignment2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.Data
import com.example.cse438.cse438_assignment2.Data.Track
import com.example.cse438.cse438_assignment2.Network.TrackRepository

class TrackViewModel (application: Application): AndroidViewModel(application){


        //live data and repository to track requests
        public var trackList: MutableLiveData<Data> = MutableLiveData()
        var trackRepository : TrackRepository = TrackRepository()

        //request to search for tracks
        fun getTracks(param: String){
            trackRepository.getTrackBySearch(trackList, param)
        }


}