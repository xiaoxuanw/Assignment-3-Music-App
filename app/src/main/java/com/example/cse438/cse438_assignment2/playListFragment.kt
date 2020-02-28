package com.example.cse438.cse438_assignment2.fragment

import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.cse438.cse438_assignment2.Data.Playlist
import com.example.cse438.cse438_assignment2.PlaylistViewModel

import com.example.cse438.cse438_assignment2.R
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.create_playlist.*
import kotlinx.android.synthetic.main.create_playlist.view.*
import kotlinx.android.synthetic.main.fragment_playlist.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class playListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    public lateinit var createPlaylistButton: Button
    private var playlistViewModel: PlaylistViewModel? = null

    val playlistList: ArrayList<Playlist> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)

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

        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)


        // Sets an onclick listener on the dialog box button
        mAlertDialog.submitPlaylist.setOnClickListener {
            val p = Playlist(
                dialogView.playlistName.text.toString(),
                dialogView.playlistDescription.text.toString()
            )
            // If the string is empty, we do not want to accept that as an input
            playlistViewModel!!.insert(p)

            mAlertDialog.dismiss()
        }
    }

}

