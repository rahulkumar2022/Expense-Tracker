package com.synergeticsciences.expensetracker.data.model

// import androidx.room.Entity
// import androidx.room.PrimaryKey

// @Entity(tableName = "categories")
data class Category(
    // @PrimaryKey
    val name: String,
    val icon: String,
    val color: String,
    val isDefault: Boolean = false
)

object DefaultCategories {
    val categories = listOf(
        Category("Food", "restaurant", "#FF7043", true),
        Category("Travel", "flight", "#2196F3", true),
        Category("Shopping", "shopping_bag", "#9C27B0", true),
        Category("Rent", "home", "#795548", true),
        Category("Entertainment", "movie", "#E91E63", true),
        Category("Healthcare", "local_hospital", "#F44336", true),
        Category("Transportation", "directions_car", "#607D8B", true),
        Category("Education", "school", "#3F51B5", true),
        Category("Utilities", "electrical_services", "#FF9800", true),
        Category("Other", "category", "#9E9E9E", true)
    )
}
