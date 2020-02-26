package com.example.cse438.cse438_assignment2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Data.Track
import com.example.cse438.cse438_assignment2.R




//Defining and binding for the view holder
class TrackViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.track_list_item, parent, false)) {
    private val trackNameView: TextView

    init {
        trackNameView = itemView.findViewById(R.id.my_song_name)
    }

    fun bind(track:Track){
        trackNameView?.text = track.songName
    }
}

//define the adapter for the recycler view
class TrackListAdapter(private val list: ArrayList<Track>)
    : RecyclerView.Adapter<TrackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrackViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track: Track = list[position]
        holder.bind(track)
    }

    override fun getItemCount(): Int = list.size

    }

