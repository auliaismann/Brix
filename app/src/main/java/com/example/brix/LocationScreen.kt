package com.example.brix

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
import androidx.compose.ui.unit.sp

val poppinsThin = FontFamily(Font(resId = R.font.poppins_light))

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
            // Header Lokasi dan Pengaturan
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
                            painter = painterResource(id = R.drawable.kucing),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .background(Color.Gray)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Tasa",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = poppinsThin,
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
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    // Kotak Daftar hasil toko
                    LocationCustomBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp)
                            .padding(start = 14.dp, end = 14.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(8.dp) // Spasi antar item
                        ) {
                            // Icon target dan teks lokasi
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 11.dp, end = 12.dp, bottom = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.target),
                                    contentDescription = "Target Icon",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color.Unspecified
                                )
                                Spacer(modifier = Modifier.width(9.dp))
                                Column {
                                    Text(
                                        text = "Gunakan lokasi saat ini",
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontFamily = poppinsThin,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                                        )
                                    )
                                    Text(
                                        text = "Jln. Blekping in ur area",
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontFamily = poppinsThin
                                        )
                                    )
                                }
                            }
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
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )

                                SearchBox(
                                    placeholderText = "Pasir Halus",
                                    onSearchClick = { /* Tambahkan aksi untuk pencarian */ }
                                )
                            }

                            // List hasil pencarian toko
                            SearchResultItem(
                                storeName = "Toko Pembangunan Gedagedi",
                                address = "Jln. ive been married for long time ago"
                            )
                            SearchResultItem(
                                storeName = "Toko Belutut tcihh",
                                address = "Jln. Dingin tetapi tidak kejam"
                            )
                            SearchResultItem(
                                storeName = "Toko beda agama",
                                address = "Jln. in aja dulu"
                            )
                            SearchResultItem(
                                storeName = "Toko Zigma Rizz",
                                address = "Jln. Skibidi"
                            )
                            SearchResultItem(
                                storeName = "Toko Wait..",
                                address = "Jln. He don't love me like ily"
                            )
                            SearchResultItem(
                                storeName = "Toko APT",
                                address = "Jln. Rose blekping"
                            )
                        }
                    }
                }
            }
        }

        // BottomNavigationBar tetap berada di posisi paling bawah
        LocationBottomNavigationBar(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun SearchBox(
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
fun SearchResultItem(storeName: String, address: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(2.dp, Color(0xFFB0A070), shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            text = storeName,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = poppinsThin,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = address,
            style = MaterialTheme.typography.bodyMedium.copy(fontFamily = poppinsThin)
        )
    }
}

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
                    painterResource(id = R.drawable.location_ijo),
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
                    painterResource(id = R.drawable.chat_abu),
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
                    painterResource(id = R.drawable.profile_abu),
                    contentDescription = "Account",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            },
            label = { Text("Account") },
            selected = false,
            onClick = { navController.navigate("account_screen") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLocationScreen() {
    LocationScreen(navController = rememberNavController())
}