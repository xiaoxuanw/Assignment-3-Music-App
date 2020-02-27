package com.example.cse438.cse438_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cse438.cse438_assignment2.Data.Track
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Adapter.TrackListAdapter
import com.example.cse438.cse438_assignment2.R
import com.google.android.material.tabs.TabItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Instances to be initiated later
    lateinit var viewModel: TrackViewModel
    lateinit var searchButton: SearchView
    lateinit var searchBox: EditText
    lateinit var albumCover: List<ImageView>
    lateinit var playListTab: TabItem

    //An arraylist that holds the tracks
    var  trackList: ArrayList<Track> = ArrayList()
    var chartList: ArrayList<Track> = ArrayList()
    //onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set initial variables
        searchBox = findViewById<EditText>(R.id.search_box)
        searchButton = findViewById<SearchView>(R.id.search_button)
        viewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)
        //playListTab = tab_layout

        //set recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = TrackListAdapter(chartList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this,2)


        //observe the allEvents LiveData
        viewModel.chartList.observe(this, Observer { tracks ->
            // Update the cached copy of the words in the adapter.
            chartList.clear()
            chartList.addAll(tracks.data)
            adapter.notifyDataSetChanged()
        })

        //autofill the recycler view on creation
        viewModel.getCover()

        //click listener for when search button is pressed from edit text
        searchBox.setOnEditorActionListener() { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val searchAdapter = TrackListAdapter(trackList,this)
                recyclerView.adapter = searchAdapter
                recyclerView.layoutManager = GridLayoutManager(this,2)

                //observe the allEvents LiveData
                viewModel.trackList.observe(this, Observer { tracks ->
                    // Update the cached copy of the words in the adapter.
                    trackList.clear()
                    trackList.addAll(tracks.data)
                    adapter.notifyDataSetChanged()
                })
                //your code here
                val input: String = searchBox.text.toString()
                viewModel.getTracks(input)
                true
            }
            false
        }

        //Set listener for tab
        playListTab.setOnClickListener {
            val intent = Intent(this, infoActivity::class.java)
            startActivity(intent)
            println("view switched")
        }
    }
}
