package com.example.brix

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

// Inisialisasi FontFamily untuk Poppins-Thin
val poppinsLightC = FontFamily(Font(resId = R.font.poppins_light))

@Composable
fun ChatScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp), // Padding bottom agar tidak tertutup oleh BottomNavigation
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Gambar profil, nama pengguna, dan ikon pengaturan
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
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
                            painter = painterResource(id = R.drawable.kucing),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(70.dp)
                                .clip(CircleShape)
                                .background(Color.Gray)
                                .padding(5.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Tasa",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = poppinsLightC,
                                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    IconButton(onClick = { /* Tambahkan aksi untuk ikon pengaturan */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.setting),
                            contentDescription = "Settings Icon",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
            }

            // Konten yang bisa di-scroll, menggunakan LazyColumn
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    // Kotak Pertama - Daftar hasil toko
                    ChatCustomBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(700.dp)
                            .padding(start = 17.dp, end = 17.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(8.dp) // Spasi antar item
                        ) {
                            // Kotak Pencarian
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 12.dp, end = 12.dp, bottom = 8.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = "Nama Barang",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontFamily = poppinsLightC,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                SearchBoxC(
                                    placeholderText = "Pasir Halus",
                                    onSearchClick = { /* Tambahkan aksi untuk pencarian */ }
                                )
                            }

                            // List hasil pencarian toko
                            SearchResultItemC(
                                storeName = "Toko Pembangunan Gedagedi",
                                address = "Jln. ea"
                            )
                            SearchResultItemC(
                                storeName = "Toko Belutut tcihh",
                                address = "Jln. Dingin tetapi tidak kejam"
                            )
                            SearchResultItemC(
                                storeName = "Toko beda agama",
                                address = "Jln. in aja dulu"
                            )
                            SearchResultItemC(
                                storeName = "Toko Zigma Rizz",
                                address = "Jln. Skibidi"
                            )
                            SearchResultItemC(
                                storeName = "Toko Wait..",
                                address = "Jln. He don't love me like ily"
                            )
                            SearchResultItemC(
                                storeName = "Toko APT",
                                address = "Jln. Rose blekping"
                            )
                        }
                    }
                }
            }
        }

        // BottomNavigationBar tetap berada di posisi paling bawah
        ChatBottomNavigationBar(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter) // Posisi di paling bawah
        )
    }
}

@Composable
fun SearchBoxC(
    placeholderText: String,
    onSearchClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = placeholderText,
            style = MaterialTheme.typography.bodyMedium.copy(fontFamily = poppinsThin),
            color = Color.Gray
        )
        IconButton(onClick = onSearchClick) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
        }
    }
}

@Composable
fun FeatureItemC(text: String, iconId: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "$text Icon",
            modifier = Modifier.size(32.dp),
            tint = Color.Unspecified
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(fontFamily = poppinsThin)
        )
    }
}

@Composable
fun SearchResultItemC(storeName: String, address: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(2.dp, Color(0xFFB0A070), shape = RoundedCornerShape(8.dp)) // Menambahkan garis hijau army
            .padding(12.dp),
        horizontalAlignment = Alignment.Start // Mengatur alignment horizontal ke start
    ) {
        Text(
            text = storeName,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = poppinsLightC,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = address,
            style = MaterialTheme.typography.bodyMedium.copy(fontFamily = poppinsLightC)
        )

        // Tombol Contact
        Button(
            onClick = { /* Tambahkan aksi untuk menghubungi */ },
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.End), // Mengatur tombol agar berada di pojok kanan
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black) // Warna latar belakang hitam
        ) {
            Text(
                text = "Contact",
                color = Color.White // Warna teks putih
            )
        }
    }
}

// Composable untuk CustomBox dengan shape yang bisa diatur
@Composable
fun ChatCustomBox(
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
fun ChatBottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
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
                    painterResource(id = R.drawable.chat_ijo),
                    contentDescription = "Chat",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified // Menggunakan warna asli dari ikon
                )
            },
            label = { Text("Chat") },
            selected = true,
            onClick = { navController.navigate("chat_screen") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.profile_abu),
                    contentDescription = "Account",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            },
            label = { Text("Account") },
            selected = false,
            onClick = {
                // Ambil userId dari FirebaseAuth
                val userId = FirebaseAuth.getInstance().currentUser?.uid
                if (userId != null) {
                    // Navigasi langsung ke ProfileScreen dengan userId
                    navController.navigate("profile_screen/$userId")
                } else {
                    Log.e("Navigation", "User ID tidak ditemukan")
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    val navController = rememberNavController()
    ChatScreen(navController = navController)
}
