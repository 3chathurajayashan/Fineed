package com.example.fineed

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class home_page_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get the profile icon
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)

        // Set click listener
        profileIcon.setOnClickListener {
            val intent = Intent(this, userProfile_MainActivity::class.java)
            startActivity(intent)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> {
                    // Already on home
                    true
                }
                R.id.nav_search -> {
                    val intent = Intent(this, search_page_MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_notifications -> {
                    val intent = Intent(this, notifications_page_MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
