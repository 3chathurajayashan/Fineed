package com.example.fineed

import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditProfile_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔙 Back button functionality
        val backIcon = findViewById<ImageView>(R.id.backIcon)  // make sure you have an ImageView with this id
        backIcon.setOnClickListener {
            val intent = Intent(this, userProfile_MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
