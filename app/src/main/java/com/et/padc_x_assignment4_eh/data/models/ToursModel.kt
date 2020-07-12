package com.et.padc_x_assignment4_eh.data.models

import androidx.lifecycle.LiveData
import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO

interface ToursModel {

    /*fun getAllTours(
        onSuccess :(List<TourVO>, List<TourVO>) -> Unit,
        onFailure : (String) -> Unit ){
    }

    fun getTourCountryByName(name : String) : TourVO{
        return TourVO()
    }*/

    fun getAllDataFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getAllCountry(onError: (String) -> Unit): LiveData<List<CountryVO>>

    fun getAllTour(onError: (String) -> Unit): LiveData<List<TourVO>>

    fun getTourCountryByName(name : String) : LiveData<TourVO>

}