/*
package com.et.padc_x_assignment4_eh.network.dataagents

import com.et.padc_x_assignment4_eh.data.vos.CountryTourVO
import com.et.padc_x_assignment4_eh.network.ToursApi
import com.et.padc_x_assignment4_eh.network.response.GetAllToursResponse
import com.et.padc_x_assignment4_eh.utils.BASE_URL
import com.et.padc_x_assignment4_eh.utils.EM_NULL_NEWS_RESPONSE
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.network.dataagents.ToursDataAgent

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgent : ToursDataAgent {

    private var mNewsApi: ToursApi? = null

    init {
        val mOkHttpClient  = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()

        mNewsApi = retrofit.create(ToursApi::class.java)
    }

    override fun getAllTours(accessToken: String,
                            onSuccess: (List<CountryTourVO>, List<CountryTourVO>) -> Unit,
                            onFailure: (String) -> Unit) {

        val getAllNewsCall = mNewsApi?.getAllTours()

        getAllNewsCall?.enqueue(
            object : Callback<GetAllToursResponse>{
                override fun onFailure(call: Call<GetAllToursResponse>, t: Throwable) {
                    onFailure.invoke(t.message ?: EM_NULL_NEWS_RESPONSE)
                }

                override fun onResponse(
                    call: Call<GetAllToursResponse>,
                    response: Response<GetAllToursResponse>
                ) {
                    val getAllNewsResponse = response.body()
                    if (getAllNewsResponse != null){
                        if (getAllNewsResponse.isResponseOk()){
                            getAllNewsResponse.data?.let{
                                onSuccess.invoke(getAllNewsResponse.data?.country, getAllNewsResponse.data?.tours)
                            }
                        } else {
                            onFailure.invoke(getAllNewsResponse.message)
                        }
                    } else {
                        onFailure.invoke(EM_NULL_NEWS_RESPONSE)
                    }
                }
            }) // interface implement
    }
}*/
