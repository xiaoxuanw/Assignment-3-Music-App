package com.example.cse438.cse438_assignment2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.ChartArtist
import com.example.cse438.cse438_assignment2.Data.DataArtist
import com.example.cse438.cse438_assignment2.Network.ArtistRepository


class TopArtistViewModel(application: Application) : AndroidViewModel(application) {

    //live data and repository to track requests
    public var chartartistList: MutableLiveData<ChartArtist> = MutableLiveData()
    var artistRepository: ArtistRepository =
        ArtistRepository()

    //request to get chart
    fun getCover() {
        artistRepository.getArtistByChart(chartartistList)
    }
}