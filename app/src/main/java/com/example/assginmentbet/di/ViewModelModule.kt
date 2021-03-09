package com.example.assginmentbet.di

import com.example.assginmentbet.viewmodel.DashBoardViewModel
import com.example.assginmentbet.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        DashBoardViewModel()
    }
}