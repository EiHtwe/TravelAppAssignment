package com.et.padc_x_assignment4_eh.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.et.padc_x_assignment4_eh.data.models.ToursModellmpl
import com.et.padc_x_assignment4_eh.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    var mTourModel = ToursModellmpl

    override fun onTapItems(name: String) {
        mView?.navigateToDetails(name)
    }


    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllTour(lifeCycleOwner)
        requestAllCountry(lifeCycleOwner)
    }

    private fun requestAllTour(lifeCycleOwner: LifecycleOwner) {
        mTourModel.getAllTour(onError = {
            mView?.displayEmptyView()
        }).observe(lifeCycleOwner, Observer {
            if (it.isEmpty()) mView?.displayEmptyView() else mView?.displayTourList(it)
        })

    }

    private fun requestAllCountry(lifeCycleOwner: LifecycleOwner) {
        mTourModel.getAllCountry(onError = {
            mView?.displayEmptyView()
        }).observe(lifeCycleOwner, Observer {
            if (it.isEmpty()) mView?.displayEmptyView() else mView?.displayCountryList(it)
        })

    }
}