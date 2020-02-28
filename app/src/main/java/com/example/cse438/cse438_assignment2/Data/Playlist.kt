package com.example.cse438.cse438_assignment2.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "playlist")
data class Playlist(
 @ColumnInfo(name = "playlistName")
 val playlistName: String,
 @ColumnInfo(name = "playlistDescription")
 val playlistDescription: String,
 @ColumnInfo(name = "playlistGenre")
 val playlistGenre: String,
 @ColumnInfo(name = "playlistRating")
 val playlistRating: Int
)
{
 @PrimaryKey(autoGenerate = true)
 var id: Int = 0
}
