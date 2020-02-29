package com.example.cse438.cse438_assignment2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_artist_playlist.*

class artistActivity: AppCompatActivity() {
    var artistPlaylist : String = ""
    public lateinit var artistplaylistView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_playlist)

        //Get the info from the main activity
        val intent = intent
        artistPlaylist = intent!!.getStringExtra("artistPlaylist")
}
    override fun onStart() {
        super.onStart()

        //set the view
        artistplaylistView = artist_playlist
        artistplaylistView.text = artistPlaylist
    }

    }
