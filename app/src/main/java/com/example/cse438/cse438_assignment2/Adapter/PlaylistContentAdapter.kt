package com.example.cse438.cse438_assignment2.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.Data.PlaylistRoomDatabase
import com.example.cse438.cse438_assignment2.Data.Tracklist
import com.example.cse438.cse438_assignment2.Network.PlaylistRepository
import com.example.cse438.cse438_assignment2.Network.TracklistDao
import com.example.cse438.cse438_assignment2.Network.TracklistRepository
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.TracklistViewModel
import com.example.cse438.cse438_assignment2.infoActivity
import com.example.cse438.cse438_assignment2.playlistContentActivity

class PlaylistContentViewHolder(private val playlistTitle:String, private val playlistGenre: String,
                                private val playlistRating:Int,inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.playlist_content_item, parent, false)) {
    private val playlistTrackName : TextView
    private val playlistTrackArtist : TextView
    private val playlistTrackAlbum : TextView
    private val playlistTrackGenre : TextView
    private val playlistTrackDuration : TextView
    private val playlistTrackRating : TextView
    private val playlistContentItemLayout: RelativeLayout = itemView.findViewById(R.id.playlist_content_item_layout)
    private val contentDeleteButton: Button = itemView.findViewById(R.id.content_delete_button)
    private val parent = parent

    init {
        playlistTrackName = itemView.findViewById(R.id.playlistTrackName)
        playlistTrackArtist = itemView.findViewById(R.id.playlistTrackArtist)
        playlistTrackAlbum = itemView.findViewById(R.id.playlistTrackAlbum)
        playlistTrackGenre = itemView.findViewById(R.id.playlistTrackGenre)
        playlistTrackDuration = itemView.findViewById(R.id.playlistTrackDuration)
        playlistTrackRating = itemView.findViewById(R.id.playlistTrackRating)
    }
    fun bind(tracklist: Tracklist) {
        playlistTrackName.text = "Track: " + tracklist.trackName
        playlistTrackArtist.text = "Artist: " + tracklist.trackArtistName
        playlistTrackDuration.text = "Duration: " + tracklist.trackTime.toString()
        playlistTrackGenre.text = "Genre: " + playlistGenre
        playlistTrackRating.text = "Rating: " + playlistRating
    }
    fun setClickListener(activity: Activity?){
        contentDeleteButton.setOnClickListener(){
            val playlistDao = PlaylistRoomDatabase.getDatabase(activity?.applicationContext).playlistDao()
            val tracklistDao = PlaylistRoomDatabase.getDatabase(context = activity?.applicationContext).tracklistDao()
            val playlistRepository = PlaylistRepository(playlistDao)
            val repository = TracklistRepository(tracklistDao)
            val playlist_id = playlistRepository.getPlaylistIdByName(playlistTitle)
            repository.deleteTrackForPlaylist(playlist_id)
            println("delete clicked")
            //val viewModel = ViewModelProvider(activity).get(TracklistViewModel::class.java)
        }
    }
}
//create the listener for the recycler view
class PlaylistContentAdapter(private val playlistTitle:String, private val playlistGenre: String,
                             private val playlistRating:Int,val list: ArrayList<Tracklist>?,
                             private val activity: Activity?)
    : RecyclerView.Adapter<PlaylistContentViewHolder>() {
    private var listEvents : ArrayList<Tracklist>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistContentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlaylistContentViewHolder(playlistTitle,playlistGenre,playlistRating,inflater, parent)
    }

    //bind the object
    override fun onBindViewHolder(holder: PlaylistContentViewHolder, position: Int) {
        val event: Tracklist = listEvents!!.get(position)
        holder.bind(event)
        holder.setClickListener(activity)
    }

    //set the count
    override fun getItemCount(): Int = list!!.size
}
