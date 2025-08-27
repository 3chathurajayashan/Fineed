package com.example.fineed

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Load animations
        val scaleFadeAnim = AnimationUtils.loadAnimation(this, R.anim.scale_fade_in)
        val slideUpFadeAnim = AnimationUtils.loadAnimation(this, R.anim.slideup_fade).apply { startOffset = 500 }

        // Start animations
        findViewById<TextView>(R.id.textView5).startAnimation(scaleFadeAnim)
        findViewById<TextView>(R.id.textView6).startAnimation(slideUpFadeAnim)

        // Move to next page after 5 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, onBoard_MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}
