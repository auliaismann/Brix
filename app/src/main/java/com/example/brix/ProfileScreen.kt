package com.example.brix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.brix.ui.theme.BrixTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrixTheme {
                val navController = rememberNavController()
                ProfileScreen(navController = navController)
            }
        }
    }
}

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF232526), Color(0xFF414345)) // Gradient background
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp) // Padding for top margin
        ) {
            // Row for displaying the app name "Brixx"
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp) // Left padding for spacing
            ) {
                Text(
                    text = "Brixx",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 16.dp) // Spacing between app name and settings icon
                        .offset(y = 10.dp) // Move the text down a little
                )
            }

            // Settings Icon on the top-right corner
            IconButton(
                onClick = { /* Add action for settings icon */ },
                modifier = Modifier.align(Alignment.TopEnd) // Aligning the icon to the top-right corner
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.setting), // Use the appropriate settings icon
                    contentDescription = "Settings Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.White // Use white for the settings icon
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Center profile picture, name, and date
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().weight(1f), // Allow it to take up available space
            verticalArrangement = Arrangement.Center // Vertically center the content
        ) {
            // Profile picture
            Image(
                painter = painterResource(id = R.drawable.kucing),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(128.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )


            Spacer(modifier = Modifier.height(8.dp))

            // Name
            Text(
                text = "Tasa",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            // Date
            Text(
                text = "Monday, 20 Jan",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 14.sp
            )
        }

        // User details section in a card
        Card(
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f), // This takes up the remaining space
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                ProfileDetailCard(label = "Name", value = "Tasa")
                ProfileDetailCard(label = "Phone Number", value = "080080808080")
                ProfileDetailCard(label = "E-mail", value = "tasa@gmail.com")
            }
        }

        // Bottom navigation bar
        ProfileBottomNavigationBar(navController = navController)
    }
}

@Composable
fun ProfileDetailCard(label: String, value: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFB0A070)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Text(
                text = value,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun ProfileBottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home_abu),
                    contentDescription = "Home",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("home_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.location_abu),
                    contentDescription = "Location",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            },
            label = { Text("Location") },
            selected = false,
            onClick = { navController.navigate("location_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.chat_abu),
                    contentDescription = "Chat",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            },
            label = { Text("Chat") },
            selected = false,
            onClick = { navController.navigate("chat_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.profile_ijo),
                    contentDescription = "Profile",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            },
            label = { Text("Profile") },
            selected = true,
            onClick = { /* Active profile page */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}
