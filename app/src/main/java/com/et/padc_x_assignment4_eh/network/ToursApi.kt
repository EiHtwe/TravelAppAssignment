package com.et.padc_x_assignment4_eh.network


import com.et.padc_x_assignment4_eh.network.response.GetAllCountriesResponse
import com.et.padc_x_assignment4_eh.network.response.GetAllToursResponse
import com.et.padc_x_assignment4_eh.utils.GET_COUNTRY
import com.et.padc_x_assignment4_eh.utils.GET_TOURS
import io.reactivex.Observable
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface ToursApi {

    @GET(GET_TOURS)
    fun getAllTours( ) : Observable<GetAllToursResponse>

    @GET(GET_COUNTRY)
    fun getAllCountry( ) : Observable<GetAllCountriesResponse>
    // @GET("/getAllTours")
}