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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import com.example.brix.R

// Define the font family for Poppins (make sure you have the correct font file in res/font)
val PoppinsLightS = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light)
)

// Define the regular Poppins font
val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal)
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
                        .height(380.dp)
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
                                    fontWeight = FontWeight(600),
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

                            Spacer(modifier = Modifier.height(16.dp))

                            // Button Confirm
                            Button(
                                onClick = { /* No action */ },
                                modifier = Modifier
                                    .width(150.dp) // Set the width of the button
                                    .height(40.dp) // Set the height of the button
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

                // Divider with "OR" in the middle
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Divider(
                        color = Color.Black,
                        thickness = 1.dp,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "OR",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = poppinsFontFamily
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Divider(
                        color = Color.Black,
                        thickness = 1.dp,
                        modifier = Modifier.weight(1f)
                    )
                }

                // Row with three logos

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(1.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(1.dp, Alignment.CenterHorizontally) // Reduce space between icons
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google Logo",
                        modifier = Modifier.size(38.dp),
                        contentScale = ContentScale.Fit
                    )

                    Image(
                        painter = painterResource(id = R.drawable.applelogo),
                        contentDescription = "Apple Logo",
                        modifier = Modifier.size(60.dp),
                        contentScale = ContentScale.Fit
                    )

                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook Logo",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Fit
                    )
                }

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
                            navController.navigate("login") // Ensure "login" route is defined in your NavHost
                        }
                    )
                }
            }
        }
    }
}

// Custom TextField Composable
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

// Preview function
@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun SignupScreenPreview() {
    SignupScreen(rememberNavController())
}
