package com.et.padc_x_assignment4_eh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.et.padc_x_assignment4_eh.R
import com.et.padc_x_assignment4_eh.data.vos.CountryVO
import com.et.padc_x_assignment4_eh.data.vos.TourVO
import com.et.padc_x_assignment4_eh.delegates.ActionDelegated
import com.et.padc_x_assignment4_eh.view.viewholder.CountryViewHolder
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewholder.BaseViewHolder

class CountryAdapter(delegated: ActionDelegated) : BaseRecyclerAdapter<BaseViewHolder<CountryVO>, CountryVO>() {

    val mDelegated : ActionDelegated = delegated

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_country, parent, false)
        return CountryViewHolder(view, mDelegated)
    }
}