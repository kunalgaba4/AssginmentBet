package com.example.assginmentbet.repositories

import com.example.assginmentbet.modal.User
import com.example.assginmentbet.network.UserApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single

class BaseServiceImp(private val userApi: UserApi): BaseService {
    override fun getUSerLoginInfo(username: String, password: String): Single<User> {
        return userApi.userLogin(username, password)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { error ->
                System.err.println("The error message is: " + error.message)
            }
    }
}