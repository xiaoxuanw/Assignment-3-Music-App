package com.example.cse438.cse438_assignment2.Data

import android.app.Notification
import java.net.URL

data class Artist (
    val id:Int,
    val name: String,
    val link: String,
    val share: String,
    val picture: String,
    val picture_small:String,
    val picture_medium:String,
    val picture_big:String,
    val picture_xl:String,
    val nb_album: Int,
    val nb_fan: Int,
    val radio: Boolean,
    val type: String
)
