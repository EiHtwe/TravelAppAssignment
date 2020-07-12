package com.et.padc_x_assignment4_eh

import android.app.Application
import androidx.work.*
import com.et.padc_x_assignment4_eh.data.models.ToursModellmpl
import com.et.padc_x_assignment4_eh.persistence.db.TourCountryDB
import java.util.concurrent.TimeUnit

class ToursApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ToursModellmpl.initDatabase(applicationContext)

//        getNewsOneTime()
//        getNewsPeriodically()
//        getNewsWhileInDozeMode()
    }

}