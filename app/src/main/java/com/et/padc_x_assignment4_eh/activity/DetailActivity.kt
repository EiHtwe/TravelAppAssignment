package com.et.padc_x_assignment4_eh.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.et.padc_x_assignment4_eh.R
import com.et.padc_x_assignment4_eh.adapters.ImageAdapter
import com.et.padc_x_assignment4_eh.data.models.ToursModel
import com.et.padc_x_assignment4_eh.data.models.ToursModellmpl
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var mToursModel: ToursModel


    companion object{

        const val NAME = "name"

        fun newIntent(context : Context, name : String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(NAME, name)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //mToursModel = ToursModellmpl()

       /* var vo: TourVO = mToursModel.getTourCountryByName("Sea Flower Resort")

        if (vo.photos.size > 0) {
            Glide.with(this)
                .load(vo.photos.get(0))
                .into(ivCountryImage)

            var layoutManager: LinearLayoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            var adapter = ImageAdapter()
            rvImage.adapter = adapter
            rvImage.layoutManager = layoutManager

            tvBooking.text = "Booking \n ${vo.reviews[0].totalReview}"
            tvReviews.text = "Based on ${vo.reviews[0].totalReview} tours"
            tvHotelOur.text = "Booking \n ${vo.reviews[1].totalReview}"
            tvReviews2.text = "Based on ${vo.reviews[1].totalReview} tours"
            tvDesc.text = vo.desc

            adapter.setNewData(vo.photos)

        }*/
    }
}
