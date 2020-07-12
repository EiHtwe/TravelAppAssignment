package com.et.padc_x_assignment4_eh.InstrumentationTest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.persistence.daos.TourDao
import com.et.padc_x_assignment4_eh.persistence.db.TourCountryDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DataBaseTest {
    private lateinit var mTourDao : TourDao
    private lateinit var db : TourCountryDB
    private lateinit var tourList : ArrayList<TourVO>

    @Before
    fun setUpDB(){

        val context= ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,TourCountryDB::class.java).build()
        mTourDao=db.tourDao()
    }

    @After
    fun closeDB(){
        db.close()
    }

    @Test
    fun databaseTest(){
        val tourFirst = TourVO()
        tourFirst.name="test data"
        tourFirst.location="Yangon"
        tourFirst.desc = "test Description"
        tourFirst.rating=4.5

        tourList.add(tourFirst)

        mTourDao.insertAllTours(tourList)
        assert(mTourDao.getTourByName(tourFirst.name).value?.name == tourFirst.name)
    }
}