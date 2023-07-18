package com.example.futebola.login

import android.util.Log
import com.example.futebola.login.LoginSocialMode.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

class LoginInteractor(
    private val loginIncognitoRepository: LoginIncognitoRepository
) {
    suspend fun loginWithSocial(loginSocialMode: LoginSocialMode): Flow<AppUser> = flow {
        when (loginSocialMode) {
            GOOGLE -> {}
            APPLE -> {}
            FACEBOOK -> {}
            INCOGNITO -> {}
        }
    }
}