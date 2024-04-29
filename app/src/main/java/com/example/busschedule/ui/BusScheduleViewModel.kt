/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.BusScheduleApplication
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.ScheduleDao
import kotlinx.coroutines.flow.Flow


/*
 * This class provides data to the UI and handles UI-related actions
 */
//Interacts with DAO and provides data to UI
class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {
//Property holds a reference to the DAO
    // Get entire bus schedule
    fun getFullSchedule(): Flow<List<BusSchedule>> = scheduleDao.getSchedule()

    // Get schedule based on stop name
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> =
        scheduleDao.getAppointment(stopName)


    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            /*Companion object containing a factory property, which is an instance of
            ViewModelProvider.Factory.  Used to create an instance of the BusScheduleViewModel
             */

/*
initializer function initializes the BusScheduleViewModel instance.  It obtains
the DAO instance from the application context and passes it to viewModel constructor.
 */
            initializer {
                val application = (this[APPLICATION_KEY] as BusScheduleApplication)
                BusScheduleViewModel(application.database.scheduleDao())
            }
        }
    }
}
