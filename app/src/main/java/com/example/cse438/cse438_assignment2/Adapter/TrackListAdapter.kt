package com.example.cse438.cse438_assignment2.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Data.Track
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.infoActivity
import com.squareup.picasso.Picasso
import com.example.cse438.cse438_assignment2.MainActivity

//Defining and binding for the view holder
class TrackViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.track_list_item, parent, false)) {
    private val trackNameView: TextView = itemView.findViewById(R.id.track_name)
    private val albumImage: ImageView = itemView.findViewById(R.id.album_image)
    fun bind(track:Track){
        trackNameView?.text = track.title
    }

    fun bindImage(track: Track){
        Picasso.get()
            .load(track.album.cover)
            .into(albumImage)
    }

    fun setClickListener(track: Track, activity: Activity){
        albumImage.setOnClickListener(){
            //Extract variables from track
            var trackTitle = track.title
            var trackArtistName = track.artist.name
            var trackAlbumTitle = track.album.title
            var trackRank = track.rank
            var trackDuration = track.duration
            var trackAlbumCover = track.album.cover

            //set context
            var context = albumImage.context
            //Intent to info activity
            val intent = Intent(activity, infoActivity::class.java)
            intent.putExtra("trackTitle", trackTitle)
            intent.putExtra("trackArtistName", trackArtistName)
            intent.putExtra("trackAlbumTitle", trackAlbumTitle)
            intent.putExtra("trackRank", trackRank)
            intent.putExtra("trackDuration", trackDuration)
            intent.putExtra("trackAlbumCover", trackAlbumCover)
            context.startActivity(intent)
            println("clicked")
        }
    }
}

//define the adapter for the recycler view
class TrackListAdapter(private val list: ArrayList<Track>, private val activity: Activity)
    : RecyclerView.Adapter<TrackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrackViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track: Track = list[position]
        holder.bind(track)
        holder.bindImage(track)
        holder.setClickListener(track, activity)
        //println(track.title)
    }

    override fun getItemCount(): Int = list.size

}
