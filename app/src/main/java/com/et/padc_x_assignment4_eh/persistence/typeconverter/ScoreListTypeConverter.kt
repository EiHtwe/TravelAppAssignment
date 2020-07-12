package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.persistence.typeconverter

import androidx.room.TypeConverter
import com.et.padc_x_assignment4_eh.data.vos.ScoresReviewVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoreListTypeConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<ScoresReviewVO>) : String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonString: String): ArrayList<ScoresReviewVO>{
        val userListType = object : TypeToken<ArrayList<ScoresReviewVO>>() {}.type
        return Gson().fromJson(commentListJsonString, userListType)
    }
}
