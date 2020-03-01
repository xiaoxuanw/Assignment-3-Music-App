package com.example.cse438.cse438_assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_artist_info.*
import kotlinx.android.synthetic.main.activity_artist_info.artist_name
import kotlinx.android.synthetic.main.activity_artist_info.back_button

class artistActivity: AppCompatActivity() {
    var artistName : String = ""
    var artistShareLink : String = ""
    var artistPicture : String = ""
    var nb_album : Int = 0
    var nb_fan : Int = 0

    public lateinit var artistNameView: TextView
    public lateinit var artistShareLinkView: TextView
    public lateinit var artistPictureView: ImageView
    public lateinit var backButton: Button
    public lateinit var nb_albumView: TextView
    public lateinit var nb_fanView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_info)

        //Get the info from the main activity
        val intent = intent
        artistName = intent!!.getStringExtra("artistName")
        //artistShareLink = intent!!.getStringExtra("artistShareLink")
        artistPicture = intent!!.getStringExtra("artistPicture")
        nb_album = intent!!.getIntExtra("nb_album",0)
        nb_fan = intent!!.getIntExtra("nb_fan",0)
    }



    override fun onStart() {
        super.onStart()

        //Set the view
        artistNameView = artist_name
        artistNameView.text = "Artist: " + artistName
        artistShareLinkView = artist_Share_Link
        artistShareLinkView.text = "Share Link: " + artistShareLink
        artistPictureView = artist_image
        Picasso.get()
            .load(artistPicture)
            .into(artistPictureView)
        backButton = back_button
        nb_albumView = numberOfAlbum
        nb_albumView.text = "Number of Album: " + nb_album
        nb_fanView = numberOfFan
        nb_fanView.text = "Number Of Fan: " + nb_fan

        //Set onclick listener for back button
        backButton.setOnClickListener{
            //Intent to top artist fragment
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
