package com.example.cse438.cse438_assignment2.Network/*
package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.LiveData
import com.example.cse438.cse438_assignment2.Data.Track

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

interface PlaylistDao {
    @Query("SELECT * FROM tracks")
    fun getSong(): LiveData<List<Track>>

    @Insert
    fun insert(track:Track)

    @Query("DELETE FROM jokes")
    fun deleteAll()
}
}*/
