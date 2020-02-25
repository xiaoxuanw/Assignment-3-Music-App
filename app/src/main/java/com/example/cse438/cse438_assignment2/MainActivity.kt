package com.example.cse438.cse438_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.SearchView
import androidx.lifecycle.ViewModelProviders
import com.example.cse438.cse438_assignment2.Data.Track
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R

class MainActivity : AppCompatActivity() {

    //Instances to be initiated later
    lateinit var viewModel: TrackViewModel
    lateinit var searchButton: SearchView
    lateinit var searchBox: EditText

    //An arraylist that holds the tracks
    var  trackList: ArrayList<Track> = ArrayList<Track>()

    //onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set initial variables
        searchBox = findViewById<EditText>(R.id.search_box)
        searchButton = findViewById<SearchView>(R.id.search_button)
        viewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)
    }
}
