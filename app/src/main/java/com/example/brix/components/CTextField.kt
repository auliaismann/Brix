package com.example.brix.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brix.ui.theme.poppinsFontFamily

@Composable
fun CTextField(
    onValueChange: (String) -> Unit = {},
    hint: String,
    value: String,
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = hint,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.Gray
                )
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = poppinsFontFamily,
            color = Color.White
        ),
        singleLine = true
        )
}