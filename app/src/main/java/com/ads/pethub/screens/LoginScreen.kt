package com.ads.pethub.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ads.pethub.R
import com.ads.pethub.components.LoginInput
import com.ads.pethub.components.PasswordInput
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton
import com.ads.pethub.components.StandardLink
import com.ads.pethub.ui.theme.RobotoRegular
import com.ads.pethub.viewModel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {

    val userNameState = viewModel.userName.observeAsState(initial = "")
    val passwordState = viewModel.password.observeAsState(initial = "")
    val isVisibleState = viewModel.isVisible.observeAsState(initial = false)

    val userId = viewModel.getUserId()

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.pethub_login_gray))
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 32.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.pethub_logo),
                    contentDescription = "PetHub Logo",
                    modifier = Modifier.height(200.dp)
                    )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(166.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    LoginInput(
                        username = userNameState.value) { viewModel.onUsernameChanged(it) }

                    PasswordInput(
                        isVisible = isVisibleState.value,
                        password = passwordState.value,
                        onValueChange = { viewModel.onPasswordChanged(it) },
                        isVisibleChange = { viewModel.onIsVisibleChanged() }
                    )

                    StandardLink(text = "Esqueceu sua senha?", fontSize = 14 ) { }
                }

                StandardButton(
                    text = "Entrar",
                    onClick = {
                        viewModel.getAccessToken {
                            navController.navigate("home/$userId")
                        }
                    }
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Novo usuário?  ",
                        fontFamily = RobotoRegular,
                        fontSize = 14.sp
                        )
                    StandardLink(text = "Cadastre-se", fontSize = 16 ) { }
                }

                Text(
                    text = "PetHub - 2024",
                    fontFamily = RobotoRegular,
                    fontSize = 12.sp
                )
            }
        }
    }
}