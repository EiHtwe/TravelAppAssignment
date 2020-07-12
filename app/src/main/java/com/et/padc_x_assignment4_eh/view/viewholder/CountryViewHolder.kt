package com.et.padc_x_assignment4_eh.view.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.delegates.ActionDelegated
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.view_item_country.view.*

class CountryViewHolder(itemView : View, delegate : ActionDelegated) : BaseViewHolder<CountryVO>(itemView) {

    var ss : String = ""

    init {

        itemView.setOnClickListener { delegate.onTapItems(ss) }
    }


    override fun bindData(data: CountryVO) {

        Glide.with(itemView.context)
            .load(data.photos.get(0))
            .into(itemView.ivCountry)
        itemView.tvLocation.text = data.location
        ss = data.name
    }

}