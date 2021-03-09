package com.example.assginmentbet.di

import com.example.assginmentbet.network.FakeInterceptor
import com.example.assginmentbet.network.UserApi
import com.example.assginmentbet.repositories.BaseService
import com.example.assginmentbet.repositories.BaseServiceImp
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetworkModule = module{
    single<UserApi>(){
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://blablabla.to/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient().newBuilder().addInterceptor(FakeInterceptor()).build()
                ).build().create(UserApi::class.java)
    }

    single<BaseService> {
        BaseServiceImp(
            get()
        )
    }
}

