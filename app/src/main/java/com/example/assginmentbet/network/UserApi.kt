package com.example.assginmentbet.network

import com.example.assginmentbet.modal.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {
    @FormUrlEncoded
    @POST("login")
    fun userLogin(@Field("username")username: String, @Field("password")password: String): Single<User>
}