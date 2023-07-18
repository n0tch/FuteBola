package com.example.futebola.login.di

import com.example.futebola.login.LoginIncognitoRepository
import com.example.futebola.login.LoginInteractor
import com.example.futebola.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModel(get()) }
    factory { LoginIncognitoRepository(get()) }
    factory { LoginInteractor(get()) }
}
