package com.example.fineed

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.TextPaint
import android.widget.Button

class signin_page_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin_page_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signUpButton = findViewById<Button>(R.id.signbutton) // Make sure your button has this ID in XML
        signUpButton.setOnClickListener {
            // You can add validation here before redirecting
            val intent = Intent(this, finalOnboard_MainActivity::class.java)
            startActivity(intent)
            finish() // optional: closes the signup page
        }

        // Get the TextView
        val forgetPasswordText = findViewById<TextView>(R.id.textView7)

        // Set click listener
        forgetPasswordText.setOnClickListener {
            val intent = Intent(this, forget_password_MainActivity::class.java)
            startActivity(intent)
        }


        val signUpText = findViewById<TextView>(R.id.textViewSignUp)

        // Create Spannable for clickable text
        val spannable = SpannableString("Not registered yet? Sign up")
        val startIndex = spannable.toString().indexOf("Sign up")
        val endIndex = startIndex + "Sign up".length

        // Blue color
        spannable.setSpan(ForegroundColorSpan(Color.BLUE), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Clickable span without underline
        spannable.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Navigate to Sign Up page
                val intent = Intent(this@signin_page_MainActivity, signup_page_MainActivity::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false // Remove underline
                ds.color = Color.BLUE      // Keep blue color
            }
        }, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        signUpText.text = spannable
        signUpText.movementMethod = LinkMovementMethod.getInstance()
    }
}
