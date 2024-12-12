package com.example.brix

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.brix.components.CButton
import com.example.brix.components.DontHaveAccount
import com.example.brix.ui.theme.poppinsFontFamily

@Composable
fun WelcomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Image(painter = painterResource(id = R.drawable.screenawal),
                contentDescription = null,
                modifier = Modifier
                    .width(320.dp)
                    .height(240.dp),
                contentScale = ContentScale.Fit
            )

            Text("Welcome",
                fontSize = 32.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(700),
                color = Color.Black
            )

            Text("Elevate Your Projects with the Perfect Materials!",
                textAlign = TextAlign.Center,
                fontFamily = poppinsFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))

            CButton(
                text = "Sign In With Email",
                onClick = {
                    navController.navigate("login") { // Ganti "signin" menjadi "login" sesuai rute di MainActivity
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }
            )

            DontHaveAccount(
                onSignupTap = {
                    navController.navigate("signup")
                }
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}