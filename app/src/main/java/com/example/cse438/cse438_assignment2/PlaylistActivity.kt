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
    public lateinit var createPlaylistButton: Button


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

        //Get the info from the main activity
        val intent = intent
        trackTitle = intent!!.getStringExtra("trackTitle")
        trackArtistName = intent!!.getStringExtra("trackArtistName")
        trackAlbumTitle = intent!!.getStringExtra("trackAlbumTitle")
        trackRank = intent!!.getIntExtra("trackRank", 0)
        trackDuration = intent!!.getIntExtra("trackDuration", 0)
        trackAlbumCover = intent!!.getStringExtra("trackAlbumCover")
    }

    override fun onStart() {
        super.onStart()

        //Set the view
        createPlaylistButton = addPlaylistButton
        createPlaylistButton.setOnClickListener {

        }
    }

    private fun dialogView() {
        // Opens the dialog view asking the user for
        val dialogView = LayoutInflater.from(this).inflate(R.layout.create_playlist, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Enter playlist name and description")
        val mAlertDialog = mBuilder.show()

        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)


        // Sets an onclick listener on the dialog box button
        mAlertDialog.submitPlaylist.setOnClickListener {
            val p = Playlist(
                dialogView.playlistName.text.toString(),
                dialogView.playlistDescription.text.toString()
            )

            // If the string is empty, we do not want to accept that as an input
            playlistViewModel!!.insert(p)

            mAlertDialog.dismiss()
        }
    }
}



