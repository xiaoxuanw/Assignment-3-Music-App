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
    val playlistList: ArrayList<Playlist> = ArrayList()
    val trackInPlaylist: ArrayList<Playlist> = ArrayList()


    private var playlistViewModel: PlaylistViewModel? = null

    var trackTitle: String = ""
    var trackArtistName: String = ""
    var trackAlbumTitle: String = ""
    var trackRank: Int = 0
    var trackDuration: Int = 0
    var trackAlbumCover: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)

    }

    override fun onStart() {
        super.onStart()

    }


}



