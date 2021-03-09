package com.example.assginmentbet.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assginmentbet.network.ApiServiceClient
import com.example.assginmentbet.network.FakeInterceptor
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseViewModel(private var apiServiceClient: ApiServiceClient? = null) : ViewModel() {

    fun getApiServiceClient(): ApiServiceClient? {
        if (apiServiceClient !== null) {
            return apiServiceClient
        }

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://blablabla.to/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient().newBuilder().addInterceptor(FakeInterceptor()).build())


        apiServiceClient = ApiServiceClient(retrofitBuilder)

        return apiServiceClient
    }
}