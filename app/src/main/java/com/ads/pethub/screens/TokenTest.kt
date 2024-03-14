package com.ads.pethub.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.model.Pet
import com.ads.pethub.service.PetHubFactory
import com.ads.pethub.service.auth.AuthFactory
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
    var petName by remember { mutableStateOf("") }

    val token: String =
        "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJHZjl3QlJsOU1RUTJpWEpvYWFJR2tEQ2ZwZGZ3VmloZGRxQkszRmJ6Z0lFIn0.eyJleHAiOjE3MTAzNTc1NzMsImlhdCI6MTcxMDM1Mzk3MywianRpIjoiMDY0OTk3ZjUtYjg3OS00YjdlLWFiYWYtZTVmMGViMTAyODYyIiwiaXNzIjoiaHR0cHM6Ly9hY2Vzc28uY2d0ZWNub2xvZ2lhLmNvbS5ici9yZWFsbXMvcGV0aHViIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6Ijg1YWQ1NTk0LTdjODAtNGEyYy05NmZiLTdkMzQ2ODk5ZmJmMSIsInR5cCI6IkJlYXJlciIsImF6cCI6InBldGh1Yi1hcGkiLCJzZXNzaW9uX3N0YXRlIjoiZTBkNTAwYzItMzkxNy00MzhiLWE4NDktMTg1N2JlMjNkNTk0IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIvKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiZGVmYXVsdC1yb2xlcy1wZXRodWIiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsicGV0aHViLWFwaSI6eyJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJlMGQ1MDBjMi0zOTE3LTQzOGItYTg0OS0xODU3YmUyM2Q1OTQiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6Ikx1Y2FzIE1lcmlubyIsInByZWZlcnJlZF91c2VybmFtZSI6Imx1Y2FzLm1lcmlubyIsImdpdmVuX25hbWUiOiJMdWNhcyIsImZhbWlseV9uYW1lIjoiTWVyaW5vIiwiZW1haWwiOiJsdWNhc2ZtZXJpbm9AZ21haWwuY29tIn0.dtsFPkU3sPC40jsJysD21T5NO-pLizegiXM1ZN0XtzWXtvAxn_n4L10gYcRKHdupjHaLj-KZTu5AxXbPJFW1PXK-LwrdJkWt-cnw4S0zVj6Ds0x8ZmjchMZO12gd50ToeVSlkzbwl5_YoNkCyXf9f8jv52sUGDg3sPMFkOn-4AZp3ZNfAOb0QMk2jlgMXBvJPb55fmK1TsJ2zqx2kLD-nBfutTV698QavbIYFHgEmSy7BTbygwJLYMjbZ3IBcdPYBWc5d71v1Npuvl2XiXQfFsJZLCI8q9C-_NYpiyPxiH8cwTznM3BRuNik1Ec9r-ns3J1MA9DvFDSI76_BN1UA9g"
//    val token: String = "abcd"
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            StandardHeader(onClick = { navController.navigate("$userId/home") })

            Column(
                modifier = Modifier.padding(horizontal = 32.dp)
            ) {
                ScreenTitle(title = "TOKEN TEST")

                Text(text = "Token: $tokenState")

                Spacer(modifier = Modifier.height(32.dp))

                StandardButton(text = "Get Token") {

                    AuthFactory().getAuthService()
                        .getAccessToken(username = "lucas.merino", password = "IMhObKL4MAiyFrk=")
                        .enqueue(object : Callback<AuthToken> {
                            override fun onResponse(
                                call: Call<AuthToken>,
                                response: Response<AuthToken>
                            ) {
                                Log.i("RE ", "${response.code()}")
                                tokenState = response.body()?.accessToken.toString()
//                        tokenState = response.body()?.accessToken ?: "Não foi possível recuperar o Token"
                            }

                            override fun onFailure(call: Call<AuthToken>, t: Throwable) {
                                tokenState = "Falha na chamada: ${t.message}"
                            }
                        })
                }

                Spacer(modifier = Modifier.height(64.dp))

                Text(text = "PET: $petName")
                Spacer(modifier = Modifier.height(32.dp))
                StandardButton(text = "Get Pet") {
                    PetHubFactory(token).getPetService().getPetById(3)
                        .enqueue(object : Callback<Pet> {
                            override fun onResponse(call: Call<Pet>, response: Response<Pet>) {
                                Log.i("RE ", "${response.code()}")
                                petName = response.body()?.name.toString()
                            }

                            override fun onFailure(call: Call<Pet>, t: Throwable) {
                                petName = "Falha na chamada: ${t.message}"
                            }

                        })

                }
            }

        }
    }
}

