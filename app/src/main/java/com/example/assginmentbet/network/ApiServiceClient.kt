package com.example.assginmentbet.network

import com.example.assginmentbet.modal.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit

open class ApiServiceClient() {
    lateinit var userApi: UserApi

    constructor(retrofitBuilder: Retrofit.Builder) : this() {
        userApi = retrofitBuilder.build()
            .create(UserApi::class.java)
        //Added a comment
    }

    fun getUSerLoginInfo(username: String, password: String): Single<User> {
        return userApi.userLogin(username, password)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { error -> System.err.println("The error message is: " + error.message) }
    }
}