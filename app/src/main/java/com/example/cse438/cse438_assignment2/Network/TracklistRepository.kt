package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.LiveData
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.Data.Tracklist
import com.example.cse438.cse438_assignment2.Data.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TracklistRepository (private val tracklistDao: TracklistDao){
    val allTracklist: LiveData<List<Tracklist>> = tracklistDao.getTracklists()

    fun insert(tracklist: Tracklist){
        CoroutineScope(Dispatchers.IO).launch {
            tracklistDao!!.insert(tracklist)
            println("track inserted")
        }
    }
}