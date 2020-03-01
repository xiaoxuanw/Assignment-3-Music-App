package com.example.cse438.cse438_assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cse438.cse438_assignment2.Adapter.ArtistViewHolder
import com.example.cse438.cse438_assignment2.Data.Artist
import kotlinx.android.synthetic.main.fragment_topartist.*

class topArtistFragment : Fragment() {
    //Instances to be initiated later
    lateinit var viewModel: TopArtistViewModel

    //An array list that holds the artist
    var chartArtistList: ArrayList<Artist> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topartist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set initial variables
        viewModel = ViewModelProviders.of(this).get(TopArtistViewModel::class.java)

        //set recycler view
        val recyclerView = recyclerViewArtist
        val adapter = ArtistViewHolder.ArtistAdapter(chartArtistList, activity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this.context, 2)

        //observe the allEvents LiveData
        viewModel.chartartistList.observe(this, Observer { artists ->
            // Update the cached copy of the words in the adapter.
            chartArtistList.clear()
            chartArtistList.addAll(artists.data)
            adapter.notifyDataSetChanged()
        })

        //autofill the recycler view on creation
        viewModel.getCover()
    }
}