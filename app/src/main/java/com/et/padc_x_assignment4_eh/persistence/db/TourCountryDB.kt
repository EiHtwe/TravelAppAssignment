package com.et.padc_x_assignment4_eh.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.persistence.daos.CountryDao
import com.et.padc_x_assignment4_eh.persistence.daos.TourDao

@Database(entities = [TourVO::class, CountryVO::class], version = 8)
abstract class TourCountryDB : RoomDatabase() {

    companion object{
        val DB_NAME = "TourCountry.DB"
        var dbInstance : TourCountryDB? = null
        fun getDBInstance(context: Context) : TourCountryDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, TourCountryDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun tourDao(): TourDao

    abstract fun countryDao(): CountryDao
}