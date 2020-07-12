package com.et.padc_x_assignment4_eh.mvp.views

import com.et.padc_x_assignment4_eh.data.vos.TourVO

interface DetailsView : BaseView {
    fun displayNewsDetails(news: TourVO)
}