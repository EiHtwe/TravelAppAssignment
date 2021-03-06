package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.network.dataagents

import com.et.padc_x_assignment4_eh.data.vos.TourVO

interface ToursDataAgent {
    fun getAllTours(accessToken : String,
                    onSuccess: (List<TourVO>, List<TourVO>) -> Unit,
                    onFailure: (String) -> Unit)
}