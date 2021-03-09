package com.example.assginmentbet.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assginmentbet.databinding.ActivityLoginBinding
import com.example.assginmentbet.utils.UserInfo
import com.example.assginmentbet.utils.Validator
import com.example.assginmentbet.viewmodel.LoginViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Consumer
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    val loginViewModel: LoginViewModel by viewModel<LoginViewModel>()
    lateinit var binding: ActivityLoginBinding
    private val disposables = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        login()
    }

    /**
     * Login Click is Handled here
     * Network Call is made by sending username and password
     * To Check Error, Enter -> username --> Error
     */
    private fun login() {
        val validator = Validator()
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            if (validator.isValidName(binding.etUsername, true)
                && validator.isValidPassword(binding.etPassword, true)){
                disposables.add(loginViewModel.loginUser(username, password)?.subscribe(Consumer {
                    if (it.isSuccessful) {
                        UserInfo.user = it
                        val intent = Intent(this, DashboardActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"Unable to Login", Toast.LENGTH_LONG).show()                    }
                } ,{ // OnError
                        t: kotlin.Throwable ->
                        Toast.makeText(this,"Unable to Login", Toast.LENGTH_LONG).show()
                })
                )
            }
        }
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}