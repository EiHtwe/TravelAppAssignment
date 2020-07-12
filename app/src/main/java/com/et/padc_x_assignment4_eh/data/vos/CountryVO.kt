package com.et.padc_x_assignment4_eh.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.et.padc_x_assignment4_eh.persistence.typeconverter.PhotosTypeConverter
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.persistence.typeconverter.ScoreListTypeConverter

@Entity(tableName = "country")
@TypeConverters(ScoreListTypeConverter::class, PhotosTypeConverter::class)

data class CountryVO(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @SerializedName("name") var name : String = "",
    @SerializedName("description") var desc : String = "",
    @SerializedName("location") var location : String = "",
    @SerializedName("average_rating") var rating : Double = 0.0,
    @SerializedName("scores_and_reviews") var reviews : ArrayList<ScoresReviewVO> = arrayListOf(),
    @SerializedName("photos") var photos : ArrayList<String> = arrayListOf()
) {
}