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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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
                .padding(bottom = 56.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header dengan profil pengguna dan pengaturan
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
                    Row(verticalAlignment = Alignment.CenterVertically) {
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
                                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                                fontWeight = FontWeight.Bold,
                                fontFamily = poppinsLight
                            )
                        )
                    }

                    IconButton(onClick = { /* Aksi pengaturan */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.setting),
                            contentDescription = "Settings Icon",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
            }

            // Konten scrollable
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Kotak pertama: Katalog, Komunitas, Konsultasi
                item {
                    CustomBox(
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
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.katalog),
                                    contentDescription = "Katalog Icon",
                                    modifier = Modifier.size(40.dp),
                                    tint = Color.Unspecified
                                )
                                Text(text = "Katalog", style = MaterialTheme.typography.bodyMedium.copy(fontFamily = poppinsLight))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.komonitas),
                                    contentDescription = "Komunitas Icon",
                                    modifier = Modifier.size(40.dp),
                                    tint = Color.Unspecified
                                )
                                Text(text = "Komunitas", style = MaterialTheme.typography.bodyMedium.copy(fontFamily = poppinsLight))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.konsultasi),
                                    contentDescription = "Konsultasi Icon",
                                    modifier = Modifier.size(40.dp),
                                    tint = Color.Unspecified
                                )
                                Text(text = "Konsultasi", style = MaterialTheme.typography.bodyMedium.copy(fontFamily = poppinsLight))
                            }
                        }
                    }
                }

                // Kotak kedua: Daftar gambar horizontal
                item {
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
                                Box(
                                    modifier = Modifier
                                        .size(80.dp)
                                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                                        .clip(RoundedCornerShape(8.dp))
                                        .shadow(4.dp, RoundedCornerShape(8.dp))
                                        .padding(4.dp)
                                ) {
                                    Image(
                                        painter = painterResource(
                                            id = when (index) {
                                                0 -> R.drawable.bahanbangunan
                                                1 -> R.drawable.arsitek
                                                2 -> R.drawable.arsitekturbangunan
                                                else -> R.drawable.arsitek
                                            }
                                        ),
                                        contentDescription = "Arsitek ${index + 1}",
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                    )
                                }
                            }
                        }
                    }
                }

                // Kotak ketiga: Artikel
                item {
                    CustomBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 14.dp, end = 14.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column {
                            Text(
                                text = "Artikel",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontFamily = poppinsLight,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(400.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(5) { index ->
                                    ArticleCard(
                                        imageRes = R.drawable.arsitekturbangunan,
                                        title = "Judul Artikel ${index + 1}",
                                        description = "Deskripsi singkat artikel ${index + 1}. Artikel ini membahas topik penting seputar pembangunan dan arsitektur modern."
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        BottomNavigationBar(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun ArticleCard(imageRes: Int, title: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Article Image",
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                maxLines = 1
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2
            )
        }
    }
}

@Composable
fun CustomBox(modifier: Modifier = Modifier, shape: CornerBasedShape, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .background(Color.White, shape = shape)
            .padding(16.dp)
    ) {
        content()
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier.fillMaxWidth()) {
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.home_ijo),
                    contentDescription = "Home",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            },
            label = { Text("Home") },
            selected = false,
            onClick = {
                navController.navigate("home_screen") {
                    popUpTo("home_screen") { inclusive = true }
                }
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.location_abu),
                    contentDescription = "Location",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            },
            label = { Text("Location") },
            selected = false,
            onClick = {
                navController.navigate("location_screen") {
                    popUpTo("location_screen") { inclusive = true }
                }
            }
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
            onClick = {
                navController.navigate("chat_screen") {
                    popUpTo("chat_screen") { inclusive = true }
                }
            }
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
                navController.navigate("account_screen") {
                    popUpTo("account_screen") { inclusive = true }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController)
}
