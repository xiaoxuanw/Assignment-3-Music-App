package com.example.cse438.cse438_assignment2

import android.app.AlertDialog
import android.os.Bundle
import com.example.cse438.cse438_assignment2.Data.Playlist
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_playlist.*
import kotlinx.android.synthetic.main.create_playlist.*
import kotlinx.android.synthetic.main.create_playlist.view.*

class PlaylistActivity : AppCompatActivity() {

    var trackTitle: String = ""
    var trackArtistName: String = ""
    var trackAlbumTitle: String = ""
    var trackRank: Int = 0
    var trackDuration: Int = 0
    var trackAlbumCover: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)

        //get from intent
        val intent = intent
        trackTitle = intent!!.getStringExtra("trackTitle")
        trackArtistName = intent!!.getStringExtra("trackArtistName")
        trackAlbumTitle = intent!!.getStringExtra("trackAlbumTitle")
        trackRank = intent!!.getIntExtra("trackRank", 0)
        trackDuration = intent!!.getIntExtra("trackDuration", 0)
        trackAlbumCover = intent!!.getStringExtra("trackAlbumCover")

        //set up selection fragment
        val fragment =
            realSelectionFragment()
        var bundle = Bundle()
        fragment.arguments=bundle
        bundle.putString("trackTitle",trackTitle)
        bundle.putString("trackArtistName",trackArtistName)
        bundle.putString("trackAlbumTitle",trackAlbumTitle)
        bundle.putInt("trackRank",trackRank)
        bundle.putInt("trackDuration",trackDuration)
        bundle.putString("trackAlbumCover",trackAlbumCover)

        //Contains slection fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.playlist_container, fragment)
        transaction.commit()

    }
}

