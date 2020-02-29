package com.example.cse438.cse438_assignment2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse438.cse438_assignment2.Adapter.PlaylistAdapter
import com.example.cse438.cse438_assignment2.Adapter.PlaylistContentAdapter
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.Data.PlaylistRoomDatabase
import com.example.cse438.cse438_assignment2.Data.Tracklist
import com.example.cse438.cse438_assignment2.Network.TracklistRepository

import com.example.cse438.cse438_assignment2.R
import kotlinx.android.synthetic.main.activity_playlist_content.*
import kotlinx.android.synthetic.main.fragment_playlist.*

class playlistContentActivity : AppCompatActivity() {

    var playlistName : String = ""
    var playlistDescription : String = ""
    var playlistGenre  : String = ""
    var playlistRating : Int = 0
    var playlist_id : Int = 0

    val tracklistList: ArrayList<Tracklist> = ArrayList()

    lateinit var playlistTitle: TextView
    lateinit var contentHomeButton: Button
    private lateinit var viewModel: TracklistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_content)

        //Get variables from last intent
        val intent = intent
        playlistName = intent.getStringExtra("playlistName")
        playlistDescription= intent.getStringExtra("playlistDescription")
        playlistGenre = intent.getStringExtra("playlistGenre")
        playlistRating = intent.getIntExtra("playlistRating",0)
        playlist_id = intent.getIntExtra("playlist_id",0)

    }

    override fun onStart() {
        super.onStart()

        //set lateinits
        contentHomeButton = playlist_content_home_button
        playlistTitle = content_playlist_title
        playlistTitle.text = playlistName

        //adapter
        var adapter = PlaylistContentAdapter(playlistName,playlistGenre,playlistRating,tracklistList,this)
        playlist_content_recycler.adapter = adapter
        playlist_content_recycler.layoutManager = LinearLayoutManager(this)
        playlist_content_recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        contentHomeButton.setOnClickListener{
           onBackPressed()
        }

        viewModel = ViewModelProvider(this).get(TracklistViewModel::class.java)

        viewModel.getTracklistByPlaylist(playlist_id).observe(this, Observer { tracklists ->
            // Update the cached copy of the words in the adapter.
            tracklistList.clear()
            tracklistList.addAll(tracklists)
            adapter.notifyDataSetChanged()
        })

    }
}
