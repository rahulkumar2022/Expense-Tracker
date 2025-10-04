package com.synergeticsciences.expensetracker.data.model

// import androidx.room.Entity
// import androidx.room.PrimaryKey
import java.util.Date

// @Entity(tableName = "users")
data class User(
    // @PrimaryKey
    val id: String,
    val name: String,
    val email: String,
    val avatar: String? = null,
    val currency: String = "₹",
    val createdAt: Date = Date(),
    val isGuest: Boolean = false
)
