package com.example.common.datastore

sealed class CallbackResult() {
    class Success(): CallbackResult()
}