package com.example.cse438.cse438_assignment2

/*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse438.cse438_assignment2.R
import kotlinx.android.synthetic.main.fragment_playlist.*

class Playlist() : Fragment() {

  //  private lateinit var viewModel: PlaylistViewModel

   private var playlist: ArrayList<Playlist> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_playlist, container, false)
 }
 override fun onStart() {
  super.onStart()

  var adapter = playlistAdapter(playlist)
  playlist_recycler_view.adapter = adapter
  playlist_recycler_view.layoutManager = LinearLayoutManager(this.context)
  playlist_recycler_view.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
  viewModel = ViewModelProvider(this).get(JokeViewModel::class.java)

  viewModel!!._jokeList.observe(this, Observer { jokes ->
   // Update the cached copy of the words in the adapter.
   playlist.clear()
   playlist.addAll(jokes)
   adapter.notifyDataSetChanged()
  })


 }
}*/
