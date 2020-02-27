package com.example.cse438.cse438_assignment2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.R

class PlaylistViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.playlist_item, parent, false)) {
    private val playlistName : TextView
    private val playlistDescription : TextView
    init {
        playlistName = itemView.findViewById(R.id.playlistName)
        playlistDescription = itemView.findViewById(R.id.playlistDescription)
    }
    fun bind(playlist: Playlist) {
        playlistName.text = playlist.playlistName
        playlistDescription.text = playlist.playlistDescription

    }
}
//create the listener for the recycler view
class PlaylistAdapter(private val list: ArrayList<Playlist>?)
    : RecyclerView.Adapter<PlaylistViewHolder>() {
    private var listEvents : ArrayList<Playlist>? = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlaylistViewHolder(inflater, parent)
    }

    //bind the object
    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val event: Playlist = listEvents!!.get(position)
        holder.bind(event)
    }

    //set the count
    override fun getItemCount(): Int = list!!.size
}