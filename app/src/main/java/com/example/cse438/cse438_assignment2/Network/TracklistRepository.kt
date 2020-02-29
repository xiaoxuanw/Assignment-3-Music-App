package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.Data.Tracklist
import com.example.cse438.cse438_assignment2.Data.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TracklistRepository (private val tracklistDao: TracklistDao){
    val allTracklist: LiveData<List<Tracklist>> = tracklistDao.getTracklists()
    var tracklistById: LiveData<List<Tracklist>>  = MutableLiveData()
    fun insert(tracklist: Tracklist){
        CoroutineScope(Dispatchers.IO).launch {
            tracklistDao!!.insert(tracklist)
            println("track inserted")
        }
    }

    fun selectAllTracks(){
        CoroutineScope(Dispatchers.IO).launch {
            tracklistDao.getTracklists()
        }
    }

    fun selectTracksByplaylist(playlist_id:Int) : LiveData<List<Tracklist>>{
        CoroutineScope(Dispatchers.IO).launch {
            tracklistById = tracklistDao.findTracksForPlaylist(playlist_id)
        }
        return tracklistById
    }


}