package com.et.padc_x_assignment4_eh.mvp.presenters

import androidx.lifecycle.ViewModel
import com.et.padc_x_assignment4_eh.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}