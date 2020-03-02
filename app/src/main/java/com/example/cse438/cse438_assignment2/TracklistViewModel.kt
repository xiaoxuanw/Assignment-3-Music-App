package com.example.cse438.cse438_assignment2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.PlaylistRoomDatabase
import com.example.cse438.cse438_assignment2.Data.Tracklist
import com.example.cse438.cse438_assignment2.Network.TracklistRepository

//
class TracklistViewModel (application: Application): AndroidViewModel(application) {
    var _tracklist: LiveData<List<Tracklist>> = MutableLiveData()
    private val repository: TracklistRepository
    var _tracklistById : LiveData<List<Tracklist>> = MutableLiveData()

    init {
        val tracklistDao = PlaylistRoomDatabase.getDatabase(application).tracklistDao()
        repository = TracklistRepository(tracklistDao)
        _tracklist = repository.allTracklist
        _tracklistById = repository.tracklistById
    }

    fun getTracklist(): LiveData<List<Tracklist>> {
        return _tracklist
    }

    fun insert(tracklist: Tracklist) {
        repository.insert(tracklist)
    }

    fun getTracklistByPlaylist(playlist_id:Int): LiveData<List<Tracklist>>{
        return repository.selectTracksByplaylist(playlist_id)
    }

    fun deleteTracklistForPlaylist(playlist_id: Int){
        return repository.deleteTrackForPlaylist(playlist_id)
    }
}