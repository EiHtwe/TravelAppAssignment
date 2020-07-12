package com.et.padc_x_assignment4_eh.data.models

import android.content.Context
import com.et.padc_x_assignment4_eh.network.ToursApi
import com.et.padc_x_assignment4_eh.persistence.db.TourCountryDB
import com.et.padc_x_assignment4_eh.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel () {
    protected lateinit var mTourApi: ToursApi
    protected lateinit var mTheDB: TourCountryDB


    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mTourApi = retrofit.create(ToursApi::class.java)
    }

    override fun init(context: Context) {
        initDatabase(context)
    }



    fun initDatabase(context: Context) {
        mTheDB = TourCountryDB.getDBInstance(context)
    }
}