package com.et.padc_x_assignment4_eh.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.et.padc_x_assignment4_eh.delegates.ActionDelegated
import com.et.padc_x_assignment4_eh.mvp.views.MainView

interface MainPresenter : ActionDelegated, BasePresenter<MainView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}