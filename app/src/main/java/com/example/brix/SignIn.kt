package com.example.brix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

val PoppinsLight = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light)
)

val poppinsSignInFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CTextFieldSignIn(
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

@Composable
fun ForgotPasswordDivider() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Forgot Password?",
            color = Color.Gray,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = poppinsSignInFontFamily
            ),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp) // Adjust padding as necessary
        )
    }

    // Divider with "OR" in the middle
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color.Black
        )

        Text(
            text = "OR",
            color = Color.Black,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = poppinsSignInFontFamily
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color.Black
        )
    }
}

@Composable
fun SignInScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var loginError by remember { mutableStateOf("") }

    // Firebase Auth instance
    val auth = FirebaseAuth.getInstance()

    // Function to handle sign-in
    fun signInWithEmailPassword() {
        if (!emailError && !passwordError && email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        // Navigate to home screen on successful login
                        navController.navigate("home_screen") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        loginError = task.exception?.localizedMessage ?: "Login failed"
                    }
                }
        }
    }

    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                        .padding(vertical = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Color.DarkGray, Color.Black)
                                )
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(27.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Sign In",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontFamily = poppinsSignInFontFamily,
                                    fontWeight = FontWeight(600),
                                    color = Color.White
                                ),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )

                            CTextFieldSignIn(
                                hint = "Email",
                                value = email,
                                onValueChange = {
                                    email = it
                                    emailError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                                }
                            )
                            if (emailError) {
                                Text(
                                    text = "Invalid email address",
                                    color = Color.Red,
                                    style = TextStyle(fontSize = 12.sp)
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            CTextFieldSignIn(
                                hint = "Password",
                                value = password,
                                onValueChange = {
                                    password = it
                                    passwordError = password.length < 6
                                }
                            )
                            if (passwordError) {
                                Text(
                                    text = "Password must be at least 6 characters",
                                    color = Color.Red,
                                    style = TextStyle(fontSize = 12.sp)
                                )
                            }

                            // Display login error if any
                            if (loginError.isNotEmpty()) {
                                Text(
                                    text = loginError,
                                    color = Color.Red,
                                    style = TextStyle(fontSize = 12.sp)
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = {
                                    signInWithEmailPassword()
                                },
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(40.dp)
                                    .padding(horizontal = 2.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black
                                )
                            ) {
                                Text(
                                    text = "Login",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = PoppinsLight
                                    )
                                )
                            }
                        }
                    }
                }

                ForgotPasswordDivider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(1.dp, Alignment.CenterHorizontally)
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
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun SignInScreenPreview() {
    SignInScreen(navController = rememberNavController())}
