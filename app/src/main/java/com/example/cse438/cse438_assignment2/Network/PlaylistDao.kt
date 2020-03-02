package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cse438.cse438_assignment2.Data.Playlist

@Dao
interface PlaylistDao {
    @Query("SELECT * FROM playlist")
    fun getPlaylists(): LiveData<List<Playlist>>

    @Insert
    fun insert(playlist: Playlist)

    @Query("DELETE FROM playlist WHERE playlistName = :playlist_Name")
    fun deletePlaylist(playlist_Name:String)

    @Query("DELETE FROM playlist")
    fun deleteAll()

    @Query("SELECT id FROM PLAYLIST WHERE playlistName = :playlist_Name")
    fun getPlaylistIdByName(playlist_Name: String) : Int

}
