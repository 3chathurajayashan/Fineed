package com.example.fineed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// -------- MODEL CLASS --------
data class Notification(
    val userName: String,
    val action: String,
    val time: String,
    val profileIcon: Int,
    val actionIcon: Int
)

// -------- ADAPTER CLASS --------
class NotificationAdapter(private val notifications: List<Notification>) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgUser: ImageView = itemView.findViewById(R.id.imgUser)
        val txtMessage: TextView = itemView.findViewById(R.id.txtNotificationMessage)
        val txtTime: TextView = itemView.findViewById(R.id.txtTime)
        val imgAction: ImageView = itemView.findViewById(R.id.imgAction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notifications[position]
        holder.imgUser.setImageResource(notification.profileIcon)
        holder.txtMessage.text = "${notification.userName} ${notification.action}"
        holder.txtTime.text = notification.time
        holder.imgAction.setImageResource(notification.actionIcon)
    }

    override fun getItemCount(): Int = notifications.size
}

// -------- MAIN ACTIVITY --------
class notifications_page_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notifications_page_main)

        // Handle insets (status/navigation bar padding)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // RecyclerView setup
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewNotifications)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy notification data (replace with DB/API later)
        val notifications = listOf(
            Notification("John", "liked your post", "2 hours ago", R.drawable.user, R.drawable.heart),
            Notification("Sarah", "commented on your photo", "5 hours ago", R.drawable.user, R.drawable.comment),
            Notification("Mike", "added a new post", "1 day ago", R.drawable.user, R.drawable.write)
        )

        recyclerView.adapter = NotificationAdapter(notifications)
    }
}
