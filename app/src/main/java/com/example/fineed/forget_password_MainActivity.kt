package com.example.fineed

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

class forget_password_MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forget_password_main)

        // Apply edge-to-edge padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Back to Sign In click
        val backToSignIn = findViewById<TextView>(R.id.backToSignIn)
        backToSignIn.setOnClickListener {
            val intent = Intent(this, signin_page_MainActivity::class.java)
            startActivity(intent)
            finish() // optional: prevent going back to forget password page
        }

        // Navigate to reset_after_MainActivity when clicking Reset Password
        val resetButton = findViewById<Button>(R.id.resetPasswordButton)
        resetButton.setOnClickListener {
            val intent = Intent(this, reset_after_MainActivity::class.java)
            startActivity(intent)
            finish() // optional: prevents going back to this page
        }
    }
}
