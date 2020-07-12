package com.et.padc_x_assignment4_eh.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.et.padc_x_assignment4_eh.R
import com.et.padc_x_assignment4_eh.adapters.CountryAdapter
import com.et.padc_x_assignment4_eh.adapters.ToursAdapter
import com.et.padc_x_assignment4_eh.data.models.ToursModel
import com.et.padc_x_assignment4_eh.data.models.ToursModellmpl
import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.delegates.ActionDelegated
import com.et.padc_x_assignment4_eh.delegates.ActionMain
import com.et.padc_x_assignment4_eh.mvp.presenters.MainPresenter
import com.et.padc_x_assignment4_eh.mvp.presenters.MainPresenterImpl
import com.et.padc_x_assignment4_eh.mvp.views.MainView
import com.et.padc_x_assignment4_eh.view.viewpods.EmptyViewPod

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ActionMain , MainView{

    private lateinit var mToursModel : ToursModel
    private lateinit var viewPodEmpty: EmptyViewPod
    private lateinit var mPresenter: MainPresenter


    private lateinit var tourAdapter: ToursAdapter
    private lateinit var countryAdapter: CountryAdapter
   // private lateinit var vpnavigation : ViewPager2
    //private lateinit var mAdapter: NewsListAdapter  // value insert လုပ်ရန်မလို but assign မလုပ်ဘဲ့ယူသုံးလို့မရ

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        hideEmptyView()
        setUpRecyclerView()
        setUpViewPod()
        mPresenter.onUiReady(this)

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    fun onRequestData(){

        mToursModel.getAllCountry (onError = {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        }).observe(this, Observer {
            if (it.isNotEmpty()){
                hideEmptyView()
                countryAdapter.setNewData(it.toMutableList())
            }
        })
        mToursModel.getAllTour {}.observe(this, Observer {
            if (it.isNotEmpty()){
                hideEmptyView()
                tourAdapter.setNewData(it.toMutableList())
            }
        })

    }

    override fun onTapDetailItem(context: Context, name: String) {
        Toast.makeText(context, name, Toast.LENGTH_LONG).show()
        //startActivity(DetailActivity.newIntent(context,name))

    }

    private fun setUpViewPod() {
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(
            "There are no news available for now",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJNma3BrRLpJZtbrs8qNKwu7EO9pdK1xxl1KW53ShKm4LbFCNZpQ&s"
        )
    }

    private fun showEmptyView() {

        vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView() {

        vpEmpty.visibility = View.GONE

    }

    override fun displayTourList(tourList: List<TourVO>) {
        tourAdapter.setNewData(tourList.toMutableList())
    }

    override fun displayCountryList(countryList: List<CountryVO>) {
        countryAdapter.setNewData(countryList.toMutableList())
    }

    override fun navigateToDetails(name: String) {
        startActivity( DetailActivity.newIntent(this, name))
    }

    override fun displayEmptyView() {
        showEmptyView()
    }
    private fun setUpRecyclerView() {
        tourAdapter = ToursAdapter(mPresenter)
        val linearLayoutManagertour = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTour.layoutManager = linearLayoutManagertour
        rvTour.adapter = tourAdapter

        countryAdapter = CountryAdapter(mPresenter)
        val linearLayoutManagercountry = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCountry.layoutManager = linearLayoutManagercountry
        rvCountry.adapter = countryAdapter
    }


}