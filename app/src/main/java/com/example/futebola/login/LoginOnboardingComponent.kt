package com.example.futebola.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onboarding.LoaderIntro

@Composable
fun LoginOnboardingComponent(onOnboardingFinished: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            shape = RoundedCornerShape(
                bottomStart = 50f,
                bottomEnd = 50f,
                topEnd = 0f,
                topStart = 0f
            ),
            color = Color(0xFF6cf542)
        ) {
            LoaderIntro(modifier = Modifier.fillMaxWidth(), image = com.example.onboarding.R.raw.step_3)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Discover your dream team",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Text(text = "some nice description goes here :)")
        }

        Column {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { onOnboardingFinished() },
                    shape = RoundedCornerShape(20),
                ) {
                    Text(text = "Vamos lá")
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    LoginOnboardingComponent {}
}