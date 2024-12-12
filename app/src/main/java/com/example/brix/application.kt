package com.example.brix

import android.app.Application
import com.google.firebase.FirebaseApp

class BrixApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Firebase
        FirebaseApp.initializeApp(this)
    }
}
