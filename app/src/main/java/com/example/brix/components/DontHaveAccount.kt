package com.example.brix.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brix.ui.theme.poppinsFontFamily

@Composable
fun DontHaveAccount(
    onSignupTap: () -> Unit = {},
) {
    Row(
        modifier = Modifier.padding(top= 12.dp, bottom = 52.dp)
    ){
        Text("Don't have an account?",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = poppinsFontFamily,
                color = Color.Black
            )
        )
        Text(" Sign Up",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(800),
                color = Color.DarkGray
            ),
            modifier = Modifier.clickable {
                onSignupTap()
            }
        )
    }
}

