package com.example.assginmentbet

import com.example.assginmentbet.modal.User
import com.example.assginmentbet.repositories.BaseService
import io.reactivex.rxjava3.core.Single

class MockBaseServiceImp(var user: User? = null) : BaseService{
    override fun getUSerLoginInfo(username: String, password: String): Single<User> {
        val mockApiObservable =  Single.just(user!!)
        return mockApiObservable
    }
}