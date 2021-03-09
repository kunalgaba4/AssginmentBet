package com.example.assginmentbet.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assginmentbet.modal.User
import com.example.assginmentbet.repositories.BaseService
import io.reactivex.rxjava3.core.Single

class LoginViewModel(private val baseService: BaseService): ViewModel() {

    fun loginUser(username: String, password: String): Single<User>? {
        return baseService.getUSerLoginInfo(username,password)
            ?.map { it }
    }
}