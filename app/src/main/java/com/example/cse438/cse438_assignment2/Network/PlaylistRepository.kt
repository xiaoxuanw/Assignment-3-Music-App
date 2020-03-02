package com.example.cse438.cse438_assignment2.Network


import androidx.lifecycle.LiveData
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.Data.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaylistRepository(private val playlistDao: PlaylistDao) {

    val allPlaylist: LiveData<List<Playlist>> = playlistDao.getPlaylists()
    var playlist_id: Int=0
    fun insert(playlist: Playlist){
        CoroutineScope(Dispatchers.IO).launch {
            playlistDao!!.insert(playlist)
        }
    }

    fun deletePlaylist(playlist: Playlist){
        CoroutineScope(Dispatchers.IO).launch {
            playlistDao!!.deletePlaylist(playlist.playlistName)
        }
    }

    fun getPlaylistIdByName(playlistName: String) : Int{
        CoroutineScope(Dispatchers.IO).launch {
            playlist_id=playlistDao!!.getPlaylistIdByName(playlistName)
        }
        return playlist_id
    }
}
