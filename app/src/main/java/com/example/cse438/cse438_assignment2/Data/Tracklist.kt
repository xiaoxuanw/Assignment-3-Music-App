package com.example.cse438.cse438_assignment2.Data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "trackList")
data class Tracklist(
    @ColumnInfo(name = "trackName")
    val trackName: String,
    @ColumnInfo(name = "trackArtistName")
    val trackArtistName: String,
    @ColumnInfo(name = "trackTime")
    val trackTime: Int,
    @ColumnInfo(name = "trackRating")
    val trackRating: Int
)