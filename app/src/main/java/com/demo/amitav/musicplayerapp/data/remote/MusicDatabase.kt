package com.demo.amitav.musicplayerapp.data.remote

import android.util.Log
import com.demo.amitav.musicplayerapp.data.entities.Song
import com.demo.amitav.musicplayerapp.other.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        var songsList: List<Song> = emptyList()
        withContext(Dispatchers.IO) {
            val collection = async { songCollection.get() }
            collection.await()
                .addOnSuccessListener { songs ->
                    songsList = songs.toObjects(Song::class.java)
                    songsList.onEach {
                        Log.d("Song Name ->", it.title)
                    }
                }
                .addOnFailureListener {
                    Log.d("On Failure ", it.message.toString())
                }
        }
        return songsList
    }
}