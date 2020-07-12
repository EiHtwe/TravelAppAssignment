package com.et.padc_x_assignment4_eh.mpv.presenters.impl

import androidx.lifecycle.Lifecycle
import com.et.padc_x_assignment4_eh.data.models.ToursModel
import com.et.padc_x_assignment4_eh.data.models.ToursModellmpl
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.mvp.presenters.MainPresenterImpl
import com.et.padc_x_assignment4_eh.mvp.views.MainView

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class TourPresenterImplTest {

    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView : MainView

    private lateinit var mModel : ToursModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        ToursModellmpl.initDatabase(ApplicationProvider.getApplicationContext())
        mModel= ToursModellmpl

        mPresenter= MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mTourModel= this.mModel as ToursModellmpl

    }

    @Test
    fun onTapTourItem_callNavigaterToDetail(){
        val tour = TourVO()
        tour.name="Test Data"

        mPresenter.onTapItems(tour.name)
        verify {
            mView.navigateToDetails(tour.name)
        }
    }

}