package com.example.brix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

val poppinsLight = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light)
)

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
            // Tambahkan gambar profil, nama pengguna, dan ikon pengaturan di sini
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth() // Mengisi lebar penuh
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Gambar profil (gunakan gambar lingkaran)
                        Image(
                            painter = painterResource(id = R.drawable.kucing), // Ganti dengan resource gambar profil
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(64.dp) // Ukuran gambar yang disesuaikan
                                .clip(CircleShape) // Membuat gambar menjadi lingkaran
                                .background(Color.Gray) // Background warna abu-abu di belakang gambar (opsional)
                        )
                        Spacer(modifier = Modifier.width(8.dp)) // Spasi antara gambar dan nama
                        Text(
                            text = "Tasa",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = MaterialTheme.typography.titleLarge.fontSize, // Membuat teks lebih besar
                                fontWeight = FontWeight.Bold, // Membuat teks menjadi bold
                                fontFamily = poppinsLight
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
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.katalog), // Ganti dengan resource icon katalog
                                    contentDescription = "Katalog Icon",
                                    modifier = Modifier.size(32.dp),
                                    tint = Color.Unspecified
                                )
                                Text(text = "Katalog",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontFamily = poppinsLight
                                    ))
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.supplier),
                                    contentDescription = "Supplier Icon",
                                    modifier = Modifier.size(32.dp),
                                    tint = Color.Unspecified // Gunakan warna asli
                                )
                                Text(text = "Supplier",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontFamily = poppinsLight
                                    ))
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.komonitas), // Ganti dengan resource icon komunitas
                                    contentDescription = "Komunitas Icon",
                                    modifier = Modifier.size(32.dp),
                                    tint = Color.Unspecified // Gunakan warna asli
                                )
                                Text(text = "Komunitas",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontFamily = poppinsLight
                                    ))
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.konsultasi), // Ganti dengan resource icon konsultasi
                                    contentDescription = "Konsultasi Icon",
                                    modifier = Modifier.size(32.dp),
                                    tint = Color.Unspecified // Gunakan warna asli
                                )
                                Text(text = "Konsultasi",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontFamily = poppinsLight
                                    ))
                            }
                        }
                    }
                }

                item {
                    // Kotak kedua
                    CustomBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(start = 14.dp, end = 14.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        LazyRow(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp)
                        ) {
                            items(4) { index ->
                                Image(
                                    painter = painterResource(id = when(index) {
                                        0 -> R.drawable.arsitek
                                        1 -> R.drawable.arsitek
                                        2 -> R.drawable.arsitek
                                        else -> R.drawable.arsitek
                                    }),
                                    contentDescription = "Arsitek ${index + 1}",
                                    modifier = Modifier
                                        .size(80.dp) // Ukuran gambar
                                        .clip(RoundedCornerShape(8.dp)) // Bentuk gambar
                                )
                            }
                        }
                    }
                }

                item {
                    // Kotak ketiga
                    CustomBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp)
                            .padding(start = 14.dp, end = 14.dp),
                        shape = RoundedCornerShape(16.dp) // Bisa ganti bentuk di sini
                    ) {
                        Text(text = "Konten lainnya",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = poppinsLight
                            ))
                    }
                }
            }
        }

        // BottomNavigationBar tetap berada di posisi paling bawah
        BottomNavigationBar(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter) // Posisi di paling bawah
        )
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
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.home_ijo),
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
                    painterResource(id = R.drawable.location_abu),
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
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
