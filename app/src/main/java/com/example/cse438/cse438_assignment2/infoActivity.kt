package com.example.cse438.cse438_assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_info.*

class infoActivity : AppCompatActivity(){
    var trackTitle : String = ""
    var trackArtistName : String = ""
    var trackAlbumTitle : String = ""
    var trackRank : Int = 0
    var trackDuration : Int = 0
    var trackAlbumCover : String = ""

    public lateinit var artistName: TextView
    public lateinit var trackInfoTitle: TextView
    public lateinit var trackInfoImage: ImageView
    public lateinit var backButton: Button
    public lateinit var trackInfoRank: TextView
    public lateinit var trackInfoDuration: TextView
    public lateinit var trackInfoAlbum: TextView
    public lateinit var addToPlaylistButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        //Get the info from the main activity
        val intent = intent
        trackTitle = intent!!.getStringExtra("trackTitle")
        trackArtistName = intent!!.getStringExtra("trackArtistName")
        trackAlbumTitle = intent!!.getStringExtra("trackAlbumTitle")
        trackRank = intent!!.getIntExtra("trackRank",0)
        trackDuration = intent!!.getIntExtra("trackDuration",0)
        trackAlbumCover = intent!!.getStringExtra("trackAlbumCover")
    }

    override fun onStart() {
        super.onStart()

        //Set the view
        artistName = artist_name
        artistName.text = "Artist: " + trackArtistName
        trackInfoTitle = trackInfo_title
        trackInfoTitle.text = "Title: " + trackTitle
        trackInfoImage = song_image
        Picasso.get()
            .load(trackAlbumCover)
            .into(trackInfoImage)
        backButton = back_button
        trackInfoRank = track_rank
        trackInfoRank.text = "Rank: " + trackRank.toString()
        trackInfoDuration = track_duration
        trackInfoDuration.text = "Duration: " + trackDuration.toString()
        trackInfoAlbum = trackAlbum_title
        trackInfoAlbum.text = "Album: " + trackAlbumTitle
        addToPlaylistButton = add_to_Playlist

        //Set onclick listener for back button
        backButton.setOnClickListener{
            //Intent to rolls activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Set onclick listener to add to playlist
        addToPlaylistButton.setOnClickListener {
            //Intent to rolls activity
            val intent = Intent(this, PlaylistActivity::class.java)
            intent.putExtra("trackTitle", trackTitle)
            intent.putExtra("trackArtistName", trackArtistName)
            intent.putExtra("trackAlbumTitle", trackAlbumTitle)
            intent.putExtra("trackRank", trackRank)
            intent.putExtra("trackDuration", trackDuration)
            intent.putExtra("trackAlbumCover", trackAlbumCover)
            startActivity(intent)
        }

    }
}