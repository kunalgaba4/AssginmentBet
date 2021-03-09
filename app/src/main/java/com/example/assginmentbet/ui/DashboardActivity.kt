package com.example.assginmentbet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.assginmentbet.databinding.ActivityDashboardBinding
import com.example.assginmentbet.modal.User
import com.example.assginmentbet.viewmodel.DashBoardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    val dashBoardViewModel: DashBoardViewModel by viewModel<DashBoardViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dashBoardViewModel.apply {
            getResponseData()
            userInfo.observe(this@DashboardActivity, Observer {
                onUserInfoUpdate(it)
            })
        }
    }

   private  fun onUserInfoUpdate(useinfo: User){
       binding.tvGreeting.text = "Welcome Back ! \n ${useinfo.username}"
   }
}