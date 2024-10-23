package com.example.brix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp), // Padding bottom agar tidak tertutup oleh BottomNavigation
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Tambahkan gambar profil dan nama pengguna di sini
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Gambar profil (gunakan gambar lingkaran)
                    Image(
                        painter = painterResource(id = R.drawable.kucing), // Ganti dengan resource gambar profil
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(60.dp) // Ukuran gambar
                            .background(Color.Gray, shape = RoundedCornerShape(30.dp)) // Lingkaran
                            .padding(4.dp), // Padding untuk efek lingkaran
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Spasi antara gambar dan nama
                    Text(text = "Tasa", style = MaterialTheme.typography.bodyMedium) // Ganti dengan nama pengguna

                }
            }

            // Kotak pertama (bentuk bisa diatur)
            CustomBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(start = 14.dp, end = 14.dp),
                shape = RoundedCornerShape(16.dp) // Bisa ganti bentuk di sini
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Katalog")
                    Text(text = "Supplier")
                    Text(text = "Komunitas")
                    Text(text = "Konsultasi")
                }
            }

            // Kotak kedua (bentuk bisa diatur)
            CustomBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 14.dp, end = 14.dp),
                shape = RoundedCornerShape(16.dp) // Bisa ganti bentuk di sini
            ) {
                Text(text = "Gambar atau item lainnya")
            }

            // Kotak ketiga (bentuk bisa diatur)
            CustomBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(start = 14.dp, end = 14.dp),
                shape = RoundedCornerShape(16.dp) // Bisa ganti bentuk di sini
            ) {
                Text(text = "Konten lainnya")
            }

            // Pindahkan Bottom Navigation Bar ke sini
            BottomNavigationBar(navController = navController)
        }
    }
}

// Composable untuk CustomBox dengan shape yang bisa diatur
@Composable
fun CustomBox(
    modifier: Modifier = Modifier,
    shape: CornerBasedShape,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.White, shape = shape)
            .padding(16.dp)
    ) {
        content()
    }
}

// Bottom Navigation Bar dengan item navigasi
@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.home_gold),
                    contentDescription = "Home",
                    modifier = Modifier.size(32.dp)
                )
            },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("home_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.location_gray),
                    contentDescription = "Location",
                    modifier = Modifier.size(32.dp)
                )
            },
            label = { Text("Location") },
            selected = false,
            onClick = { navController.navigate("location_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.chat_gray),
                    contentDescription = "Chat",
                    modifier = Modifier.size(32.dp)
                )
            },
            label = { Text("Chat") },
            selected = false,
            onClick = { navController.navigate("chat_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.profile_gray),
                    contentDescription = "Profile",
                    modifier = Modifier.size(32.dp)
                )
            },
            label = { Text("Profile") },
            selected = false,
            onClick = { navController.navigate("profile_screen") }
        )
    }
}

// Fungsi preview untuk menampilkan UI di Android Studio
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
