package com.synergeticsciences.expensetracker.data.model

// import androidx.room.Entity
// import androidx.room.PrimaryKey
import java.util.Date

// @Entity(tableName = "budgets")
data class Budget(
    // @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val amount: Double,
    val category: String? = null, // null for overall budget
    val month: Int,
    val year: Int,
    val userId: String = "default_user",
    val createdAt: Date = Date()
)
