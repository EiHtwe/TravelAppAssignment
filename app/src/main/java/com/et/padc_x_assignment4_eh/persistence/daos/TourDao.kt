package com.et.padc_x_assignment4_eh.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.et.padc_x_assignment4_eh.data.vos.TourVO

@Dao // require to annotation dao
interface TourDao {

    @Query("SELECT * FROM tours")
    fun getAllTours(): LiveData<List<TourVO>>

    @Query("SELECT * FROM tours WHERE name = :noteId" )
    fun getTourByName(noteId: String) : LiveData<TourVO>

    @Query("DELETE FROM tours")
    fun deleteAllTour()

    @Insert
    fun insertAllTours(news : List<TourVO>)
}