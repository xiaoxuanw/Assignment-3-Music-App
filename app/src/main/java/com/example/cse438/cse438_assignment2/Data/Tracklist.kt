package com.example.cse438.cse438_assignment2.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "trackList",
    foreignKeys = arrayOf(ForeignKey(entity = Playlist::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id"),
        onDelete = ForeignKey.CASCADE)))
data class Tracklist(
    @ColumnInfo(name = "trackName")
    val trackName: String,
    @ColumnInfo(name = "trackArtistName")
    val trackArtistName: String,
    @ColumnInfo(name = "trackTime")
    val trackTime: Int,
    @ColumnInfo(name = "trackRating")
    val trackRating: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}