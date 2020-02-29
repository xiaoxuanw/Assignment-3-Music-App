package com.example.cse438.cse438_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cse438.cse438_assignment2.fragment.playListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(homeFragment(), "Home")
        adapter.addFragment(playListFragment(), "PlayList")
        adapter.addFragment(topArtistFragment(), "Top Artist")
        viewPager?.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onStart() {
        super.onStart()

    }
}
