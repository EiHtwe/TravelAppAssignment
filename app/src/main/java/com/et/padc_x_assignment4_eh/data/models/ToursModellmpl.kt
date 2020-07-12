package com.et.padc_x_assignment4_eh.data.models

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.persistence.db.TourCountryDB
import com.et.padc_x_assignment4_eh.utils.DUMMY_ACCESS_TOKEN
import com.et.padc_x_assignment4_eh.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


object ToursModellmpl: ToursModel, BaseModel() {
    override fun getAllCountry(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        return mTheDB.countryDao().getAllCountry()
    }

    /* var compositeDisposable = CompositeDisposable()

     private val mTheDB: TourCountryDB = TourCountryDB.getDBInstance()

     override fun getAllCountry(onError: (String) -> Unit): LiveData<List<CountryVO>> {
         getAllCountryFromApiAndSaveToDatabase(onError)
         return mTheDB.countryDao().getAllCountry()
     }


     override fun getAllTour(onError: (String) -> Unit): LiveData<List<TourVO>> {
         getAllTourFromApiAndSaveToDatabase(onError)
         return mTheDB.tourDao().getAllTours()
     }

     *//*override fun getCountryByName(newsId: Int): LiveData<CountryVO> {

    }
*//*
    @SuppressLint("CheckResult1")
    private fun getAllTourFromApiAndSaveToDatabase(onError: (String) -> Unit){

            mTourApi.getAllTours()
            .map { it.data?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .subscribe({
                mTheDB.tourDao().insertAllTours(it)
            },{
                onError(it.localizedMessage ?: "Connection Error")
            })
    }

    @SuppressLint("CheckResult2")
    private fun getAllCountryFromApiAndSaveToDatabase(onError: (String) -> Unit){


        mTourApi.getAllCountry()
            .map { it.data?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .subscribe({
                mTheDB.countryDao().insertAllCountries(it)
            },{
                onError(it.localizedMessage ?: "Connection Error")
            })
    }

    private fun getByName(){

       // Observable.zip(mTheDB.countryDao().getAllCountry().pb, mTheDB.tourDao().getAllTours())
    }
*/


    override fun getAllTour(onError: (String) -> Unit): LiveData<List<TourVO>> {
        return mTheDB.tourDao()
            .getAllTours()
    }

    override fun getTourCountryByName(name: String): LiveData<TourVO> {
        return mTheDB.tourDao().getTourByName(name)
    }

    @SuppressLint("CheckResult")
    override fun getAllDataFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mTourApi
            .getAllTours()
            .map { it.data?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.tourDao().insertAllTours(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }


  /*  override fun getTourCountryByName(name: String): LiveData<CountryVO> {

        return mTheDB.tourDao().getTourByName(name)
    }*/
}