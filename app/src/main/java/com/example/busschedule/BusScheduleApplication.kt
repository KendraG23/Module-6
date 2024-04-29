package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.BusScheduleDatabase

class BusScheduleApplication: Application() {
    val database: BusScheduleDatabase by lazy { BusScheduleDatabase.getDatabase(this) }
}

/*
 *By initializing the Room database in the BusScheduleApplication class and making it accessible
 * through a property, you ensure that the database is initialized only once during the
 * application's lifecycle and can be easily accessed by other components,
 * such as ViewModels and DAOs, when needed.
 * This helps in managing the database instance efficiently and avoids unnecessary re-creation
 * of database instances.
 */