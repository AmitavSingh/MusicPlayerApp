package com.demo.amitav.musicplayerapp.adapters

import android.util.Log
import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import com.demo.amitav.musicplayerapp.R
import kotlinx.android.synthetic.main.list_item.view.*
import javax.inject.Inject

class SwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            val text = "${song.title} - ${song.subtitle}"
            tvPrimary.text = text

            setOnClickListener {
                onItemClickListener?.let { click ->
                    Log.d("Song Detail", song.toString())
                    click(song)
                }
            }
        }
    }


}



















