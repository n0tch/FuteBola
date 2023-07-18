package com.example.futebola.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginIncognitoRepository: LoginIncognitoRepository
) : ViewModel() {

    private val loginState: MutableStateFlow<LoginState> by lazy {
        MutableStateFlow(LoginState.LoginLoading)
    }

    fun getLoginState(): StateFlow<LoginState> = loginState

    fun loginWithSocial(socialMode: LoginSocialMode) {
        viewModelScope.launch {
            loginIncognitoRepository
                .loginIncognito()
                .catch {
                    loginState.value = LoginState.LoginError
                }.collectLatest {
                    loginState.value = LoginState.LoginSuccessfully
                }
        }
    }
}