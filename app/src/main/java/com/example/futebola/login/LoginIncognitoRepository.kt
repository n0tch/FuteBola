package com.example.futebola.login

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class LoginIncognitoRepository(
    private val firebaseAuth: FirebaseAuth,
) {
    suspend fun loginIncognito(): Flow<AppUser> = callbackFlow  {
        firebaseAuth.signInAnonymously()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.e("User", firebaseAuth.currentUser?.uid.toString())
                    trySend( AppUser(id = firebaseAuth.currentUser?.uid))
                } else {
                    Log.e("User", "Error: " + task.exception)
                }
            }

        awaitClose { close() }
    }
}