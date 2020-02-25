package com.example.cse438.cse438_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cse438.cse438_assignment2.Data.Track
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Adapter.TrackListAdapter
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

        //set recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = TrackListAdapter(trackList as ArrayList<Track>)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //observe the allEvents LiveData
        viewModel.trackList.observe(this, Observer { tracks ->
            // Update the cached copy of the words in the adapter.
            trackList.clear()
            trackList.addAll(tracks)
            adapter.notifyDataSetChanged()
        })

        //click listener for when search button is pressed from edit text
        searchBox.setOnEditorActionListener() { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                //your code here
                val input: String = searchBox.text.toString()
                viewModel.getTrackByArtist(input)
                true
            }
            false
        }
    }
}
