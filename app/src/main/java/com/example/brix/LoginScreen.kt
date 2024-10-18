package com.example.brix

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.brix.components.CButton
import com.example.brix.components.CTextField
import com.example.brix.components.DontHaveAccount
import com.example.brix.ui.theme.poppinsFontFamily
import org.tensorflow.lite.schema.Padding

@Composable
fun LoginScreen(
    navController: NavController,
) {
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 54.dp)
                    .height(100.dp)
                    .align(Alignment.Start)
                    .offset(x = (-20).dp)
            )
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                ),
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                "Sign In to Your Account.",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.Black
                ),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 24.dp)
            )

            CTextField(hint = "Email Address", value = "")
            CTextField(hint = "Password" , value = "")
            Spacer(modifier = Modifier.height(24.dp))
            CButton(text = "Sign In")
            DontHaveAccount(
                onSignupTap = {
                    navController.navigate("signup")
                }
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 648)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
