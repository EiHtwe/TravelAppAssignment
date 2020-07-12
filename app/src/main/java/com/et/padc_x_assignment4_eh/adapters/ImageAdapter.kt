package com.et.padc_x_assignment4_eh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.et.padc_x_assignment4_eh.R
import com.et.padc_x_assignment4_eh.view.viewholder.ImageViewHolder
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewholder.BaseViewHolder

class ImageAdapter : BaseRecyclerAdapter<BaseViewHolder<String>, String>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_image, parent, false)
        return ImageViewHolder(view)
    }
}