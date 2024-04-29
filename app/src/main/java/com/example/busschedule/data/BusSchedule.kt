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
package com.example.busschedule.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
 *Below is a data class object that describes the parameters needed for each creation of the
 * object type.
 * While its easy to work with in-memory data using data classes, when it comes to persisting data,
 * you need to convert data format compatible with database storage.
 * To make format compatible you convert the data class into a Table using the Room library features.
 */
@Entity(tableName = "Schedule") //Annotation marks class as a database Entity class.
data class BusSchedule(
    @PrimaryKey(autoGenerate = true) //Annotation identifies the primary key of the table. Unique id.
    val id: Int = 0,
    val stopName: String,
    val arrivalTimeInMillis: Int
)
