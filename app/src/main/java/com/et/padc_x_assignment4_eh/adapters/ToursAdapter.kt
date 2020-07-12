package com.et.padc_x_assignment4_eh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.et.padc_x_assignment4_eh.R
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.delegates.ActionDelegated
import com.et.padc_x_assignment4_eh.view.viewholder.ToursViewHolder
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewholder.BaseViewHolder

class ToursAdapter(delegate: ActionDelegated) : BaseRecyclerAdapter<BaseViewHolder<TourVO>, TourVO>() {

    val mDelegated : ActionDelegated = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TourVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_tour, parent, false)
        return ToursViewHolder(view, mDelegated)
    }
}