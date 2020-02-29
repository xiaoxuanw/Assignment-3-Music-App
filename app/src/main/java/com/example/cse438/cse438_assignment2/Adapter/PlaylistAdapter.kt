package com.example.cse438.cse438_assignment2.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.infoActivity
import com.example.cse438.cse438_assignment2.playlistContentActivity

class PlaylistViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.playlist_item, parent, false)) {
    private val playlistName : TextView
    private val playlistDescription : TextView
    private val playlistItemLayout: RelativeLayout = itemView.findViewById(R.id.playlist_item_layout)

    init {
        playlistName = itemView.findViewById(R.id.playlistName)
        playlistDescription = itemView.findViewById(R.id.playlistDescription)
    }
    fun bind(playlist: Playlist) {
        playlistName.text = playlist.playlistName
        playlistDescription.text = playlist.playlistDescription

    }
    fun setClickListener(playlist: Playlist, activity: Activity?){
        playlistItemLayout.setOnClickListener(){
            //variables from the playlist
            val playlistName = playlist.playlistName
            val playlistDescription = playlist.playlistDescription
            val playlistGenre = playlist.playlistGenre
            val playlistRating = playlist.playlistRating
            //Intent to info activity
            val intent = Intent(activity, playlistContentActivity::class.java)
            intent.putExtra("playlistName",playlistName)
            intent.putExtra("playlistDescription",playlistDescription)
            intent.putExtra("playlistGenre",playlistGenre)
            intent.putExtra("playlistRating",playlistRating)
            activity?.startActivity(intent)
            println("clicked")
        }
    }
}
//create the listener for the recycler view
class PlaylistAdapter(private val list: ArrayList<Playlist>?,private val activity: Activity?)
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
        holder.setClickListener(event,activity)
    }

    //set the count
    override fun getItemCount(): Int = list!!.size
}
