package com.example.network

import java.io.InputStream

fun InputStream.asString(): String {
    return bufferedReader().use { it.readText() }
}