package com.example.brix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.brix.ui.theme.poppinsFontFamily
import com.example.brix.R

val PoppinsLightS = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    navController: NavController,
) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {
        // Center the entire content
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                // Signup form box
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .padding(vertical = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Color.DarkGray, Color.Black)
                                )
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(24.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Sign Up",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight(500),
                                    color = Color.White
                                ),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )

                            // Text fields for input
                            CTextField(hint = "Email", value = email, onValueChange = { email = it })
                            Spacer(modifier = Modifier.height(10.dp))
                            CTextField(hint = "Username", value = username, onValueChange = { username = it })
                            Spacer(modifier = Modifier.height(10.dp))
                            CTextField(hint = "Password", value = password, onValueChange = { password = it })

                            Spacer(modifier = Modifier.height(10.dp))

                            // Button Confirm
                            Button(
                                onClick = { /* No action */ },
                                modifier = Modifier
                                    .width(150.dp) // Lebar tombol
                                    .height(40.dp) // Tinggi tombol lebih kecil
                                    .padding(horizontal = 2.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black
                                )
                            ) {
                                Text(
                                    text = "Confirm",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = PoppinsLightS
                                    )
                                )
                            }
                        }
                    }
                }

                // Google Logo
                Image(
                    painter = painterResource(id = R.drawable.google), // Pastikan nama file sesuai dengan logo di drawable
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(48.dp) // Atur ukuran logo
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Text Sign In at the bottom
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Already have an account?",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = poppinsFontFamily,
                            color = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "Sign In",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = poppinsFontFamily,
                            color = Color.Black
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate("login")
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CTextField(
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hintColor: Color = Color.LightGray
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                color = hintColor,
                fontSize = 14.sp,
            )
        },
        textStyle = TextStyle(color = Color.White, fontSize = 14.sp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedBorderColor = Color.White,
            containerColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
            .height(50.dp)
    )
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun SignupScreenPreview() {
    SignupScreen(rememberNavController())
}
