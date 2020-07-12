package com.et.padc_x_assignment4_eh.data.vos

import com.google.gson.annotations.SerializedName

data class ScoresReviewVO(
    @SerializedName("name") val name : String = "",
    @SerializedName("score") val score : Double = 0.0,
    @SerializedName("max_score") val maxScore : Int = 0,
    @SerializedName("total_reviews") val totalReview : Int = 0
) {
}