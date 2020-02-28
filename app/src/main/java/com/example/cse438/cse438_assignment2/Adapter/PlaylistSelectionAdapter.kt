package com.example.cse438.cse438_assignment2.Adapter

import android.app.Activity
import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.Data.PlaylistRoomDatabase
import com.example.cse438.cse438_assignment2.Data.Track
import com.example.cse438.cse438_assignment2.Data.Tracklist
import com.example.cse438.cse438_assignment2.Network.PlaylistRepository
import com.example.cse438.cse438_assignment2.Network.TracklistRepository
import com.example.cse438.cse438_assignment2.PlaylistViewModel
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.TracklistViewModel


class PlaylistSelectionViewHolder(inflater: LayoutInflater, parent: ViewGroup, trackTitle:String, trackArtistName: String, trackDuration:Int) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.playlist_item, parent, false)) {
    private val playlistName : TextView
    private val playlistDescription : TextView
    private val playlistItemLayout: RelativeLayout = itemView.findViewById(R.id.playlist_item_layout)
    val trackTitle = trackTitle
    val trackArtistName = trackArtistName
    val trackDuration = trackDuration

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
            val tracklistDao = PlaylistRoomDatabase.getDatabase(activity?.applicationContext).tracklistDao()
            val repository = TracklistRepository(tracklistDao)
            val t = Tracklist (
                trackTitle,
                trackArtistName,
                trackDuration,
                playlist.id
                )
            repository.insert(t)
            println("clicked")
        }
    }
}
//create the listener for the recycler view
class PlaylistSelectionAdapter(private val list: ArrayList<Playlist>?,private val activity: Activity?,trackTitle:String, trackArtistName: String, trackDuration:Int)
    : RecyclerView.Adapter<PlaylistSelectionViewHolder>() {
    private var listEvents : ArrayList<Playlist>? = list
    val trackTitle = trackTitle
    val trackArtistName = trackArtistName
    val trackDuration = trackDuration

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistSelectionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlaylistSelectionViewHolder(inflater, parent, trackTitle,trackArtistName,trackDuration)
    }

    //bind the object
    override fun onBindViewHolder(holder: PlaylistSelectionViewHolder, position: Int) {
        val event: Playlist = listEvents!!.get(position)
        holder.bind(event)
        holder.setClickListener(event,activity)
    }

    //set the count
    override fun getItemCount(): Int = list!!.size
}