package com.example.futebola.login

sealed class LoginState {
    object LoginSuccessfully: LoginState()
    object LoginError: LoginState()
    object LoginLoading: LoginState()
}
