package com.example.fineed


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class signup_page_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup_page_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Back button click listener
        val backButton = findViewById<ImageView>(R.id.backButton) // give your ImageView an id: android:id="@+id/backButton"
        backButton.setOnClickListener {
            val intent = Intent(this, signin_page_MainActivity::class.java)
            startActivity(intent)
            finish() // optional: closes the signup page
        }

        val signUpButton = findViewById<Button>(R.id.signUpButton) // Make sure your button has this ID in XML
        signUpButton.setOnClickListener {
            // You can add validation here before redirecting
            val intent = Intent(this, signin_page_MainActivity::class.java)
            startActivity(intent)
            finish() // optional: closes the signup page
        }





        val textViewSignIn = findViewById<TextView>(R.id.textViewSignIn)
        val text = "Not signed in yet? Sign in"

        val spannableString = SpannableString(text)


// Make "Sign in" blue and clickable
        val start = text.indexOf("Sign in")
        val end = start + "Sign in".length

        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick( widget: View) {
                val intent = Intent(
                    this@signup_page_MainActivity,
                    signin_page_MainActivity::class.java
                )
                startActivity(intent)
            }

            override fun updateDrawState( ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.BLUE // Blue color
                ds.isUnderlineText = false // No underline
            }
        }

        spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textViewSignIn.text = spannableString
        textViewSignIn.movementMethod = LinkMovementMethod.getInstance()

    }
}