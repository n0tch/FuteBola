package com.example.futebola.login

import androidx.annotation.DrawableRes
import com.example.futebola.R

enum class LoginSocialMode(@DrawableRes val icon: Int) {
    GOOGLE(R.drawable.google_icon),
    APPLE(R.drawable.apple_icon),
    FACEBOOK(R.drawable.fb_icon),
    INCOGNITO(R.drawable.incognito_icon)
}
