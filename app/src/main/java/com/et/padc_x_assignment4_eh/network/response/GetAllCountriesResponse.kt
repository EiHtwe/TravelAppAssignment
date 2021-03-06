package com.et.padc_x_assignment4_eh.network.response

import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.utils.CODE_RESPONSE_OK
import com.google.gson.annotations.SerializedName

class GetAllCountriesResponse(
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String = "",
    @SerializedName("data") val data: ArrayList<CountryVO> = arrayListOf()

) {
    fun isResponseOk() = (code == CODE_RESPONSE_OK) && (data != null)
}