package com.ads.pethub.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.service.auth.AuthFactory
import com.ads.pethub.service.auth.AuthRequest
import com.ads.pethub.service.auth.AuthToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TokenTest(
    navController: NavController,
    userId: Int
) {
    var tokenState by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            StandardHeader(onClick = { navController.navigate("$userId/home") })

            ScreenTitle(title = "TOKEN TEST")

            Text(text = "Token: $tokenState")

            Spacer(modifier = Modifier.height(32.dp))

            StandardButton(text = "Get Token") {
                val authRequest = AuthRequest(
                    grantType = "password",
                    clientId = "pethub-api",
                    username = "usuario",
                    password = "senha",
                    clientSecret = "segredo"
                )

                AuthFactory().getAuthService().getAccessToken(authRequest).enqueue(object : Callback<AuthToken> {
                    override fun onResponse(call: Call<AuthToken>, response: Response<AuthToken>) {
                        tokenState = response.body()?.accessToken ?: "Não foi possível recuperar o Token"
                    }

                    override fun onFailure(call: Call<AuthToken>, t: Throwable) {
                        tokenState = "Falha na chamada: ${t.message}"
                    }
                })
            }
        }
    }
}
