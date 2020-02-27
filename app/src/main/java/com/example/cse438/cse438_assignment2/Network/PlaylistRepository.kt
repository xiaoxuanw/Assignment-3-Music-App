package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.LiveData
import com.example.cse438.cse438_assignment2.Data.Track

class PlaylistRepository(private val playlistDao: PlaylistDao) {

    val allPlaylist: LiveData<List<Track>> = playlistDao.getPlaylists()
    fun insert
}