package com.example.cse438.cse438_assignment2.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse438.cse438_assignment2.Adapter.PlaylistAdapter
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.PlaylistViewModel

import com.example.cse438.cse438_assignment2.R
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.create_playlist.*
import kotlinx.android.synthetic.main.create_playlist.view.*
import kotlinx.android.synthetic.main.fragment_playlist.*

class playListFragment : Fragment() {
    public lateinit var createPlaylistButton: Button
    private lateinit var viewModel: PlaylistViewModel

    val playlistList: ArrayList<Playlist> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activity: Activity? = activity
        var adapter = PlaylistAdapter(playlistList,activity)
        playlist_recycler_view.adapter = adapter
        playlist_recycler_view.layoutManager = LinearLayoutManager(this.context)
        playlist_recycler_view.addItemDecoration(
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

        //set the buttons
        createPlaylistButton = addPlaylistButton
        createPlaylistButton.setOnClickListener {
            dialogView()
        }
    }


    private fun dialogView() {
        // Opens the dialog view asking the user for
        val dialogView = LayoutInflater.from(this.context).inflate(R.layout.create_playlist, null)

        val mBuilder = AlertDialog.Builder(this.context)
            .setView(dialogView)
            .setTitle("Enter playlist name and description")
        val mAlertDialog = mBuilder.show()

        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)


        // Sets an onclick listener on the dialog box button
        mAlertDialog.submitPlaylist.setOnClickListener {
            if (dialogView.playlistRating.text.toString().toIntOrNull() == null || dialogView.playlistName.text.toString() == ""
                || dialogView.playlistDescription.text.toString()==""
                || dialogView.playlistGenre.text.toString() == ""
            ) {
                Toast.makeText(activity,"Enter all fields, rating must be an integer", Toast.LENGTH_SHORT).show();
            } else {
                val p = Playlist(
                    dialogView.playlistName.text.toString(),
                    dialogView.playlistDescription.text.toString(),
                    dialogView.playlistGenre.text.toString(),
                    dialogView.playlistRating.text.toString().toInt()
                )
                // If the string is empty, we do not want to accept that as an input
                viewModel!!.insert(p)
                mAlertDialog.dismiss()
            }
        }
    }


    override fun onStart() {
        super.onStart()

        val activity: Activity? = this.activity
        var adapter = PlaylistAdapter(playlistList,activity)
        playlist_recycler_view.adapter = adapter
        playlist_recycler_view.layoutManager = LinearLayoutManager(this.context)
        playlist_recycler_view.addItemDecoration(
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

