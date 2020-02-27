package com.example.cse438.cse438_assignment2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.Track
import com.example.cse438.cse438_assignment2.Network.TrackRepository
//
class PlaylistViewModel (application: Application): AndroidViewModel(application) {
    var _playlist: LiveData<List<Playlist>> = MutableLiveData()
    private val repository: TrackRepository

    init {
        repository = TrackRepository(playlistDatabase.getDatabase(application).jokeDao())
        _playlist = repository.allPlaylist
    }

    fun getPlaylist(): LiveData<List<Track>> {
        return _playlist
    }

    fun insert(track: Track) {
        repository.insert(Track)
    }

    fun delete() {
        repository.delete(Track)

    }
}