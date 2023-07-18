package com.example.network.di

import com.example.network.BuildConfig
import com.example.network.DebugInterceptor
import com.example.network.ReleaseInterceptor
import com.example.network.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkDIModule = module {
    factory {
        if (BuildConfig.DEBUG) DebugInterceptor(androidContext().resources) else ReleaseInterceptor()
    }
    factory {
        RetrofitClient(get(), BuildConfig.API_FOOTBALL_URL).createClient()
    }
}