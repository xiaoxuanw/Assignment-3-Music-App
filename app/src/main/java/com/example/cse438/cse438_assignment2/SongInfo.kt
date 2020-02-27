package com.example.cse438.cse438_assignment2

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cse438.cse438_assignment2.Data.Artist
import com.example.cse438.cse438_assignment2.Data.Track
import kotlinx.android.synthetic.main.fragment_song_info.view.*
import kotlinx.android.synthetic.main.track_list_item.*


class SongInfo : Fragment() {
    private var playlistViewModel: TrackViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_song_info, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.add_to_Playlist.setOnClickListener { view ->
           // val j = Track
           // playlistViewModel!!.insert(j)

            val text = "Song Added!"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(this.context, text, duration)
            toast.show()
        }
    }
}

