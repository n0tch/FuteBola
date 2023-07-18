package com.example.futebola.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginComponent(
    socialLoginList: List<LoginSocialMode>,
    onSocialLoginClicked: (LoginSocialMode) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HeaderText()
        CredentialFields()
        SignInWithSocial(
            socialLoginList = socialLoginList,
            onSocialLoginClicked = onSocialLoginClicked
        )
    }
}

@Composable
fun HeaderText() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hello Again")
        Text(text = "Wellcome back, you've been missed!")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CredentialFields() {
    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            placeholder = {
                Text(text = "Email")
            },
            onValueChange = {}
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            placeholder = {
                Text(text = "Senha")
            },
            onValueChange = {}
        )
        Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(text = "Sign In")
        }
    }
}

@Composable
fun SignInWithSocial(
    socialLoginList: List<LoginSocialMode>,
    onSocialLoginClicked: (LoginSocialMode) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Divider(modifier = Modifier.weight(.2f))
        Text(
            modifier = Modifier.weight(.2f),
            text = "or sign in with",
            textAlign = TextAlign.Center
        )
        Divider(modifier = Modifier.weight(.2f))
    }

    LazyRow(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        items(socialLoginList) { socialModeItem ->
            SocialLoginItem(
                socialMode = socialModeItem,
                onSocialLoginClicked = onSocialLoginClicked
            )
        }
    }
}

@Composable
fun SocialLoginItem(socialMode: LoginSocialMode, onSocialLoginClicked: (LoginSocialMode) -> Unit) {
    Surface(
        modifier = Modifier.clickable { onSocialLoginClicked(socialMode) },
        border = BorderStroke(2.dp, Color.Black),
        color = Color.White,
        shape = RoundedCornerShape(15)
    ) {
        Icon(
            modifier = Modifier
                .size(42.dp)
                .fillMaxSize()
                .padding(8.dp),
            painter = painterResource(id = socialMode.icon),
            contentDescription = ""
        )
    }
}

@Preview
@Composable
fun PreviewLoginComponent() {
    LoginComponent(LoginSocialMode.values().toList()){

    }
}