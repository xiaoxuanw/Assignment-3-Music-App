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

import com.example.cse438.cse438_assignment2.R
import kotlinx.android.synthetic.main.activity_playlist_content.*

class playlistContentActivity : AppCompatActivity() {

    var playlistName : String = ""
    var playlistDescription : String = ""
    var playlistGenre  : String = ""
    var playlistRating : Int = 0

    lateinit var playlistTitle: TextView
    lateinit var contentHomeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_content)

        //Get variables from last intent
        val intent = intent
        playlistName = intent.getStringExtra("playlistName")
        playlistDescription= intent.getStringExtra("playlistDescription")
        playlistGenre = intent.getStringExtra("playlistGenre")
        playlistRating = intent.getIntExtra("playlistRating",0)

    }

    override fun onStart() {
        super.onStart()

        //set lateinits
        contentHomeButton = playlist_content_home_button
        playlistTitle = content_playlist_title
        playlistTitle.text = playlistName

        contentHomeButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
