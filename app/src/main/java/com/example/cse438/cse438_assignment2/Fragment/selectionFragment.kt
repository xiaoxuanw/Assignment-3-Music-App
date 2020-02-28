package com.example.cse438.cse438_assignment2.Fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse438.cse438_assignment2.Adapter.PlaylistAdapter
import com.example.cse438.cse438_assignment2.Adapter.PlaylistSelectionAdapter
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.PlaylistViewModel
import com.example.cse438.cse438_assignment2.R
import kotlinx.android.synthetic.main.create_playlist.*
import kotlinx.android.synthetic.main.create_playlist.view.*
import kotlinx.android.synthetic.main.fragment_playlist.*
import kotlinx.android.synthetic.main.fragment_playlist_selection.*

class selectionFragment : Fragment() {
    private lateinit var viewModel: PlaylistViewModel

    val playlistList: ArrayList<Playlist> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set the view model
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)

    }


    override fun onStart() {
        super.onStart()

        var adapter = PlaylistSelectionAdapter(playlistList)
        playlist_selection_recycler.adapter = adapter
        playlist_selection_recycler.layoutManager = LinearLayoutManager(this.context)
        playlist_selection_recycler.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        viewModel!!._playlist.observe(this, Observer { playlists ->
            // Update the cached copy of the words in the adapter.
            playlistList.clear()
            playlistList.addAll(playlists)
            adapter.notifyDataSetChanged()
        })
    }
}