package com.et.padc_x_assignment4_eh.view.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.item_view_image.view.*

class ImageViewHolder(itemView : View) : BaseViewHolder<String>(itemView) {
    override fun bindData(data: String) {
        Glide.with(itemView.context)
            .load(data)
            .into(itemView.ivImageForAll)
    }
}