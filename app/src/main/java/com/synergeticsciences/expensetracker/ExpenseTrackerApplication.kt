package com.synergeticsciences.expensetracker

import android.app.Application
// import com.synergeticsciences.expensetracker.data.database.ExpenseTrackerDatabase
import com.synergeticsciences.expensetracker.data.model.DefaultCategories

class ExpenseTrackerApplication : Application() {
    
    // val database by lazy { ExpenseTrackerDatabase.getDatabase(this) }
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize default categories
        initializeDefaultCategories()
    }
    
    private fun initializeDefaultCategories() {
        // In a real app, you would check if categories already exist
        // and only insert them if they don't
        DefaultCategories.categories.forEach { category ->
            // Insert default categories into database
            // This would be done in a background thread
        }
    }
}
