package com.example.fineed

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class finalOnboard_MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final_onboard_main)

        // Handle safe area padding for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find views
        val imageView = findViewById<ImageView>(R.id.imageView8)
        val titleText = findViewById<TextView>(R.id.textView9)
        val descText = findViewById<TextView>(R.id.textView10)
        val exploreButton = findViewById<Button>(R.id.letsgobutton)

        // Load animations
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        // Start animations with staggered delays
        imageView.startAnimation(slideUp)
        titleText.startAnimation(fadeIn.apply { startOffset = 200 })
        descText.startAnimation(fadeIn.apply { startOffset = 400 })
        exploreButton.startAnimation(slideUp.apply { startOffset = 600 })

        // Button to go to Home Page
        exploreButton.setOnClickListener {
            val intent = Intent(this, home_page_MainActivity::class.java)
            startActivity(intent)
            finish() // Close onboarding
        }
    }
}
