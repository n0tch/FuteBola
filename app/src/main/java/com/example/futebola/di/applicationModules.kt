package com.example.futebola.di

import com.example.futebola.firebase.firebaseModule
import com.example.futebola.login.di.loginModule
import com.example.network.di.networkDIModule

val applicationModules = listOf(
    networkDIModule,
    firebaseModule,
    loginModule
)