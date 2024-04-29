package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile



/*
Room database class named "BusScheduleDatabase" containing BusSchedule class objects, version 1,
and ability to exportSchema assigned false value.
 */

@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class BusScheduleDatabase : RoomDatabase() {
    abstract fun scheduleDao():ScheduleDao //This functions returns a ScheduleDao object.
    //This function is used to obtain and instance of the DAO interface for performing database operations.

    //Similar to static methods & properties, contains methods & properties that are associated with
    //the class itself rather than instances of the class.
    companion object {
        @Volatile //Ensures changes to Instance variable are immediately visible to other threads.
        private var Instance: BusScheduleDatabase?= null //Holds the single instance of the database

        /*
         * Static method that returns and instance of BusScheduleDatabase.
         * Receives a Context parameter & either return the existing Instance if its not null
         * or creates a new instance using builder.
         */
        fun getDatabase(context: Context): BusScheduleDatabase {
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, BusScheduleDatabase::class.java, "busSchedule_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
/*
 * Abstract class overall crates and access a Room database using singleton patter, ensuring that
 * only one instance fo the database is created and used throughout the application.
 */