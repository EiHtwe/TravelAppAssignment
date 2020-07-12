package com.et.padc_x_assignment4_eh.view.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.delegates.ActionDelegated
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.view_item_tour.view.*

class ToursViewHolder(itemView : View, delegated: ActionDelegated) : BaseViewHolder<TourVO>(itemView) {

    var ss : String = ""

    init {

        itemView.setOnClickListener { delegated.onTapItems(ss) }
    }

    override fun bindData(data: TourVO) {
        Glide.with(itemView.context)
            .load(data.photos.get(0))
            .into(itemView.ivTour)

        ss = data.name
        itemView.tvName.text = data.name
        itemView.tvDesc.text = data.location
        itemView.tvCost.text = "$ 200.00"
        itemView.tvRating.text = data.rating.toString()
    }
}