package com.example.cse438.cse438_assignment2

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cse438.cse438_assignment2.Adapter.TrackListAdapter
import com.example.cse438.cse438_assignment2.Data.Track
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_view.*


class homeFragment : Fragment() {

    //Instances to be initiated later
    lateinit var viewModel: TrackViewModel
    lateinit var searchButton: SearchView
    lateinit var searchBox: EditText
    lateinit var albumCover: List<ImageView>

    //An arraylist that holds the tracks
    var  trackList: ArrayList<Track> = ArrayList()
    var chartList: ArrayList<Track> = ArrayList()

    //oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set initial variables
        searchBox = search_box
        searchButton = search_button
        viewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)
        val activity: Activity? = activity

        //set recycler view
        val recyclerView = recyclerView
        val adapter = TrackListAdapter(chartList,activity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this.context,2)

        //observe the allEvents LiveData
        viewModel.chartList.observe(viewLifecycleOwner, Observer { tracks ->
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
                val searchAdapter = TrackListAdapter(trackList,activity)
                recyclerView.adapter = searchAdapter
                recyclerView.layoutManager = GridLayoutManager(this.context,2)

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

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()


    }
}