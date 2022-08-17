package com.demo.amitav.musicplayerapp.data.remote

import android.util.Log
import com.demo.amitav.musicplayerapp.data.entities.Song
import com.demo.amitav.musicplayerapp.other.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    fun getAllSongs(result: (List<Song>) -> Unit) {
                songCollection.get()
                    .addOnSuccessListener { songs ->
                        val songlist = arrayListOf<Song>()
                        for (song in songs) {
                            val note = song.toObject(Song::class.java)
                            songlist.add(note)
                        }
                        result.invoke(songlist)
                    }
                    .addOnFailureListener {
                        result.invoke(emptyList())
                        Log.d("On Failure ", it.message.toString())
                    }


    }

}