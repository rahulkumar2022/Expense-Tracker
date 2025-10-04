package com.synergeticsciences.expensetracker.data.model

// import androidx.room.Entity
// import androidx.room.PrimaryKey
import java.util.Date

// @Entity(tableName = "transactions")
data class Transaction(
    // @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val amount: Double,
    val category: String,
    val description: String,
    val date: Date,
    val type: TransactionType,
    val userId: String = "default_user"
)

enum class TransactionType {
    EXPENSE, INCOME
}
