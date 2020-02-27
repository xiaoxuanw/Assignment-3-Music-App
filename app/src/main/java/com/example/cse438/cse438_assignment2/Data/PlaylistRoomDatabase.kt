package com.example.cse438.cse438_assignment2.Data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cse438.cse438_assignment2.Network.PlaylistDao

@Database(entities = arrayOf(Playlist::class), version = 2)
public abstract class PlaylistRoomDatabase : RoomDatabase() {

    abstract fun playlistDao(): PlaylistDao

    //singleton pattern
    companion object {

        @Volatile
        private var INSTANCE: PlaylistRoomDatabase? = null

        fun getDatabase(context: Context) : PlaylistRoomDatabase {
            val temp = INSTANCE
            if(temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlaylistRoomDatabase::class.java,
                    "playlist_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}