package com.demo.amitav.musicplayerapp.exoplayer

import android.support.v4.media.MediaMetadataCompat
import com.demo.amitav.musicplayerapp.data.entities.Song

fun MediaMetadataCompat.toSong(): Song? {
    return description?.let {
        Song(
            mediaId = it.mediaId ?: "",
            title = it.title.toString(),
            subtitle = it.subtitle.toString(),
            songurl = it.mediaUri.toString(),
            imageurl = it.iconUri.toString()
        )
    }
}