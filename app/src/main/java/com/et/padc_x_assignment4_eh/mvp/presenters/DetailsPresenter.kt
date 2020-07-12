package com.et.padc_x_assignment4_eh.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.et.padc_x_assignment4_eh.mvp.views.DetailsView

interface DetailsPresenter : BasePresenter<DetailsView>{
    fun onUiReady(lifeCycleOwner: LifecycleOwner, newsId : Int)
}