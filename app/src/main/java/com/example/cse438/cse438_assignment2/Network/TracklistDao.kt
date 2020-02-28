package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cse438.cse438_assignment2.Data.Tracklist

@Dao
interface TracklistDao {
    @Query("SELECT * FROM trackList")
    fun getTracklists(): LiveData<List<Tracklist>>

    @Insert
    fun insert(tracklist: Tracklist)

    @Query("DELETE FROM trackList")
    fun deleteAll()

    @Query("SELECT * FROM trackList WHERE playlist_id=:playlistId")
    fun findTracksForPlaylist(playlistId:Int)

    @Query("DELETE FROM trackList WHERE playlist_id=:playlistId")
    fun deleteTracksForPlaylist(playlistId:Int)

    @Query("DELETE FROM trackList WHERE trackName = :tracklist_Name")
    fun deletePlaylist(tracklist_Name:String)
}