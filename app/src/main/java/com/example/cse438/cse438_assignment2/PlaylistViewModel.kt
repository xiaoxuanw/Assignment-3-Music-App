package com.example.cse438.cse438_assignment2


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.Data.PlaylistRoomDatabase
import com.example.cse438.cse438_assignment2.Data.Track
import com.example.cse438.cse438_assignment2.Network.PlaylistRepository
import com.example.cse438.cse438_assignment2.Network.TrackRepository
//
class PlaylistViewModel (application: Application): AndroidViewModel(application) {
    var _playlist: LiveData<List<Playlist>> = MutableLiveData()
    private val repository: PlaylistRepository

    init {
        val playlistDao = PlaylistRoomDatabase.getDatabase(application).playlistDao()
        repository = PlaylistRepository(playlistDao)
        _playlist = repository.allPlaylist
    }

    fun getPlaylist(): LiveData<List<Playlist>> {
        return _playlist
    }

    fun insert(playlist: Playlist) {
        repository.insert(playlist)
    }
}
