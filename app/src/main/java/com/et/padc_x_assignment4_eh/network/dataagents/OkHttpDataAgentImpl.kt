/*
package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.network.dataagents

import android.os.AsyncTask
import com.google.gson.Gson

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object OkHttpDataAgentImpl : ToursDataAgent {

    private val mClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    override fun getAllNews(
        accessToken: String,
        onSuccess: (List<NewsVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        GetNewsTask(
            mOkHttpClient = mClient,
            mAccessToken = accessToken,
            onSuccess = onSuccess,
            onFailure = onFailure
        ).execute()
    }

    class GetNewsTask(
        private val mOkHttpClient: OkHttpClient,
        private val mAccessToken: String,
        private val onSuccess: (List<NewsVO>) -> Unit,
        private val onFailure: (String) -> Unit
    ) :
        AsyncTask<Void, Void, GetAllNewsResponse>() {

        override fun doInBackground(vararg voids: Void): GetAllNewsResponse? {

            val formBody = FormBody.Builder()
                .add(PARAM_ACCESS_TOKEN, mAccessToken)
                .build()

            val request = Request.Builder()
                .url(BASE_URL + GET_NEWS)
                .post(formBody)
                .build()

            try {

                val response = mOkHttpClient.newCall(request).execute()

                if (response.isSuccessful) {
                    response.body?.let {
                        val responseString = it.string()
                        return Gson().fromJson<GetAllNewsResponse>(
                            responseString,
                            GetAllNewsResponse::class.java
                        )
                    }
                }

            } catch (e: Exception) {

            }

            return null
        }

        override fun onPostExecute(allNewsResponse: GetAllNewsResponse?) {
            super.onPostExecute(allNewsResponse)

            if (allNewsResponse != null) {
                if (allNewsResponse.isResponseOk()) {
                    allNewsResponse.data?.let {
                        //if data is not exists , don't call data
                        onSuccess(it.toList())
                    }
                } else {
                    onFailure(allNewsResponse.message)
                }
            } else {
                onFailure(EM_NULL_NEWS_RESPONSE)
            }
        }
    }
}
*/
