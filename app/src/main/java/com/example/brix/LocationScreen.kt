package com.example.brix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LocationScreen(navController: NavController) {
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
            // Gambar profil, nama pengguna, dan ikon pengaturan
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Gambar profil
                        Image(
                            painter = painterResource(id = R.drawable.kucing), // Ganti dengan resource gambar profil
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(70.dp) // Ukuran gambar
                                .clip(CircleShape) // Membuat gambar menjadi lingkaran
                                .background(Color.Gray) // Background warna abu-abu di belakang gambar (opsional)
                                .padding(4.dp) // Padding di sekitar gambar
                        )
                        Spacer(modifier = Modifier.width(8.dp)) // Spasi antara gambar dan nama
                        Text(
                            text = "Tasa",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = MaterialTheme.typography.titleLarge.fontSize, // Membuat teks lebih besar
                                fontWeight = FontWeight.Bold // Membuat teks menjadi bold
                            )
                        ) // Ganti dengan nama pengguna
                    }
                    // Icon pengaturan
                    IconButton(onClick = { /* Tambahkan aksi untuk ikon pengaturan */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.setting), // Ganti dengan resource icon settings
                            contentDescription = "Settings Icon",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Unspecified // Menggunakan warna asli dari ikon
                        )
                    }
                }
            }

            // Konten yang bisa di-scroll, menggunakan LazyColumn
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Mengisi ruang yang tersisa
                verticalArrangement = Arrangement.spacedBy(16.dp) // Menambahkan spasi antar item
            ) {
                item {
                    // Kotak pertama
                    LocationCustomBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(start = 14.dp, end = 14.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            FeatureItem("Katalog", R.drawable.katalog)
                            FeatureItem("Supplier", R.drawable.supplier)
                            FeatureItem("Komunitas", R.drawable.komonitas)
                            FeatureItem("Konsultasi", R.drawable.konsultasi)
                        }
                    }
                }

                item {
                    // Kotak kedua - Daftar hasil toko
                    LocationCustomBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp)
                            .padding(start = 14.dp, end = 14.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(8.dp) // Spasi antar item
                        ) {
                            // Pencarian dan hasil
                            Text(
                                text = "Hasil terdekat",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                                ),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            // List hasil pencarian toko
                            SearchResultItem(
                                storeName = "Toko Pembangunan Gedagedi",
                                address = "Jln. lurus sampe jatuh"
                            )
                            SearchResultItem(
                                storeName = "Toko Belutut tcihh",
                                address = "Jln. lurus trs mundur"
                            )
                            SearchResultItem(
                                storeName = "Toko Pembangunan Alam",
                                address = "Jln. aleah sampe sendiri"
                            )
                        }
                    }
                }
            }
        }

        // BottomNavigationBar tetap berada di posisi paling bawah
        LocationBottomNavigationBar(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter) // Posisi di paling bawah
        )
    }
}

// Fungsi untuk menampilkan fitur item dalam kotak pertama
@Composable
fun FeatureItem(text: String, iconId: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "$text Icon",
            modifier = Modifier.size(32.dp),
            tint = Color.Unspecified
        )
        Text(text = text)
    }
}

// Fungsi yang menampilkan item hasil pencarian toko
@Composable
fun SearchResultItem(storeName: String, address: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            text = storeName,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = address,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// Composable untuk CustomBox dengan shape yang bisa diatur
@Composable
fun LocationCustomBox(
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
fun LocationBottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.home_abu),
                    contentDescription = "Home",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified // Menggunakan warna asli dari ikon
                )
            },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("home_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.location_ijo),
                    contentDescription = "Location",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified // Menggunakan warna asli dari ikon
                )
            },
            label = { Text("Location") },
            selected = false,
            onClick = { navController.navigate("location_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.chat_abu),
                    contentDescription = "Chat",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified // Menggunakan warna asli dari ikon
                )
            },
            label = { Text("Chat") },
            selected = false,
            onClick = { navController.navigate("chat_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.profile_abu),
                    contentDescription = "Profile",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified // Menggunakan warna asli dari ikon
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
fun LocationScreenPreview() {
    LocationScreen(navController = rememberNavController())
}
