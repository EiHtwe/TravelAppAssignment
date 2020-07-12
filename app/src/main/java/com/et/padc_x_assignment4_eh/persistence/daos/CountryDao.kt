package com.et.padc_x_assignment4_eh.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    fun getAllCountry(): LiveData<List<CountryVO>>

    @Query("SELECT * FROM country,tours WHERE name = :noteId" )
    fun getCountryByName(noteId: String) : LiveData<TourVO>

    @Query("DELETE FROM country")
    fun deleteAllCountry()

    @Insert
    fun insertAllCountries(news : List<CountryVO>)

}