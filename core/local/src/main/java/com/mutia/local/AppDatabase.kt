package com.mutia.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mutia.local.dao.SourceDao
import com.mutia.local.entity.SourceObject
import com.mutia.local.util.Converters

@Database(entities = [SourceObject::class], version = 1, exportSchema = false)

@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun sourceDao(): SourceDao

    companion object{
        // For Singleton instantion
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, "project.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}