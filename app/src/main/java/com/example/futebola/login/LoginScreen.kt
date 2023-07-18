package com.example.futebola.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    val loginViewModel = getViewModel<LoginViewModel>()
    val loginState = loginViewModel.getLoginState().collectAsState()

    when (loginState.value) {
        LoginState.LoginError -> {}
        LoginState.LoginLoading -> {}
        LoginState.LoginSuccessfully -> {
            onLoginSuccess()
        }
    }

    LoginComponent(socialLoginList = LoginSocialMode.values().toList()) {
        loginViewModel.loginWithSocial(it)
    }
}