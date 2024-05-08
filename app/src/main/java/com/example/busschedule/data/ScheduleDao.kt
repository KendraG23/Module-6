package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


/* Data Access Object
 * The DAO will hide all the complex features involved in performing database operations
 * in the underlying persistence layer, separate from the rest of the application.
 *
 * Persistence layer = responsible for managing the storage and retrieval of data from a persistent
 * storage medium, such as a database. Often includes components like databases, tables, queries,
 * and operations for interacting the data stored in these databases.
 */

@Dao //Identify the interface as a DAO for Room.
interface ScheduleDao { //interface describes what must me used by the class implementing interface
    //Annotation in Room library to query the data in the database
    @Query("SELECT * FROM Schedule ORDER BY arrival_time ASC" )
    fun getSchedule():Flow<List<BusSchedule>>

    @Query("SELECT * FROM Schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getAppointment(stopName: String): Flow<List<BusSchedule>>

}