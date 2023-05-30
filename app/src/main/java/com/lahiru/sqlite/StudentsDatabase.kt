package com.lahiru.sqlite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentsEntity::class], version = 1)
abstract class StudentsDatabase: RoomDatabase() {

    abstract fun studentsDao(): StudentsDAO

    companion object{
        @Volatile
        private var INSTANCE: StudentsDatabase? = null

        fun getInstance(context: Context):StudentsDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentsDatabase::class.java,
                        "students_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}