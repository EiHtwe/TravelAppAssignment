package com.et.padc_x_assignment4_eh.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.et.padc_x_assignment4_eh.mvp.views.BaseView

interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}