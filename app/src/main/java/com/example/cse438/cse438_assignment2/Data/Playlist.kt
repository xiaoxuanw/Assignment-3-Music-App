package com.example.cse438.cse438_assignment2.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlist")
data class Playlist(
 @ColumnInfo(name = "playlistName")
 val playlistName: String,
 @ColumnInfo(name = "playlistDescription")
 val playlistDescription: String
)
{
 @PrimaryKey(autoGenerate = true)
 var id: Int = 0
}
