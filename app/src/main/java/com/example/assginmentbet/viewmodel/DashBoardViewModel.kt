package com.example.assginmentbet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assginmentbet.modal.User
import com.example.assginmentbet.utils.UserInfo

class DashBoardViewModel: BaseViewModel() {
     private val _userInfo = MutableLiveData<User>()
      val userInfo: LiveData<User> = _userInfo


    fun getResponseData(){
        _userInfo.postValue(UserInfo.user)
    }
}