package com.et.padc_x_assignment4_eh.mvp.views

import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO


interface MainView : BaseView{
    fun displayTourList(tourList: List<TourVO>)
    fun displayCountryList(countryList : List<CountryVO>)

    fun navigateToDetails(name: String)
    fun displayEmptyView()
}