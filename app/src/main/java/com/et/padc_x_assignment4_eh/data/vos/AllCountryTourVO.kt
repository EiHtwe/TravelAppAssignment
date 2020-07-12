package com.et.padc_x_assignment4_eh.data.vos

import com.google.gson.annotations.SerializedName

data class AllCountryTourVO(
    @SerializedName("country") val country : ArrayList<TourVO> = arrayListOf(),
    @SerializedName("popular_tours") val tours : ArrayList<TourVO> = arrayListOf()
) {

}