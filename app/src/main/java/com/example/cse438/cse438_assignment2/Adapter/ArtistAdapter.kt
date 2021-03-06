package com.example.cse438.cse438_assignment2.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Data.Artist
import com.example.cse438.cse438_assignment2.Data.Track
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.artistActivity
import com.example.cse438.cse438_assignment2.infoActivity
import com.squareup.picasso.Picasso

class ArtistViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.artist_item, parent, false)) {
    private val artistNameView: TextView = itemView.findViewById(R.id.artist_Name)
    private val artistImage: ImageView = itemView.findViewById(R.id.artist_image)

    fun bind(artist: Artist){
        artistNameView.text = artist.name
    }
    fun bindImage(artist: Artist){
        Picasso.get()
            .load(artist.picture_small)
            .into(artistImage)
    }
    fun setClickListener(artist: Artist, activity: Activity?){
        artistImage.setOnClickListener{
            //extract artist's info
            var artistName = artist.name
            var artistShareLink = artist.share
            var artistPicture = artist.picture_small
            var nbAlbum  = artist.nb_album
            var nbFan = artist.nb_fan
            var radio = artist.radio

            println(artistName)
            println(nbFan)

            var context = artistImage.context

            val intent = Intent(activity, artistActivity::class.java)
            intent.putExtra("artistName", artistName )
            intent.putExtra("artistShareLink", artistShareLink)
            intent.putExtra("artistPicture", artistPicture)
            intent.putExtra("nb_album", nbAlbum)
            intent.putExtra("nb_fan", nbFan)
            intent.putExtra("radio",radio)
            context.startActivity(intent)
            println("clicked")

        }
    }

    //define the adapter for the recycler view
    class ArtistAdapter(private val list: ArrayList<Artist>, private val activity: Activity?)
        : RecyclerView.Adapter<ArtistViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return ArtistViewHolder(inflater, parent)
        }

        override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
            val artist: Artist = list[position]
            holder.bind(artist)
            holder.bindImage(artist)
            holder.setClickListener(artist, activity)
        }

        override fun getItemCount(): Int = list.size

    }

}