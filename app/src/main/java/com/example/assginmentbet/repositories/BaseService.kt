package com.example.assginmentbet.repositories

import com.example.assginmentbet.modal.User
import io.reactivex.rxjava3.core.Single

interface BaseService {
    fun getUSerLoginInfo(username: String, password: String): Single<User>
}