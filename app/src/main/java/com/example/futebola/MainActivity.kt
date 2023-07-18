package com.example.futebola

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.example.futebola.login.LoginComponent
import com.example.futebola.login.LoginOnboardingComponent
import com.example.futebola.login.LoginSocialMode
import com.example.futebola.login.LoginState
import com.example.futebola.login.LoginViewModel
import com.example.futebola.navigation.AppNavHost
import com.example.futebola.ui.theme.FuteBolaTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
internal class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            FuteBolaTheme {
                // A surface container using the 'background' color from the theme
                AppNavHost(
                    navController = navController,
                    startDestination = "login_graph"
                )
            }
        }
    }
}