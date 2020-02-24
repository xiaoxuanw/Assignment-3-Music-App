package com.example.cse438.cse438_assignment2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.cse438.cse438_assignment2.R

class BreweryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.track_list_item, parent, false)) {
    private val trackNameView: TextView