package com.synergeticsciences.expensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
// import com.synergeticsciences.expensetracker.data.database.ExpenseTrackerDatabase
import com.synergeticsciences.expensetracker.data.model.Transaction
import com.synergeticsciences.expensetracker.data.model.TransactionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel(/* private val database: ExpenseTrackerDatabase */) : ViewModel() {
    
    private val _totalSpent = MutableStateFlow(0.0)
    val totalSpent: StateFlow<Double> = _totalSpent.asStateFlow()
    
    private val _totalIncome = MutableStateFlow(0.0)
    val totalIncome: StateFlow<Double> = _totalIncome.asStateFlow()
    
    private val _recentTransactions = MutableStateFlow<List<Transaction>>(emptyList())
    val recentTransactions: StateFlow<List<Transaction>> = _recentTransactions.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    init {
        loadMonthlyData()
    }
    
    private fun loadMonthlyData() {
        viewModelScope.launch {
            _isLoading.value = true
            
            try {
                // Sample data for now - replace with database calls later
                _totalSpent.value = 12500.0
                _totalIncome.value = 25000.0
                _recentTransactions.value = listOf(
                    Transaction(1, 250.0, "Food", "Lunch", Date(), TransactionType.EXPENSE),
                    Transaction(2, 50.0, "Transport", "Metro", Date(), TransactionType.EXPENSE),
                    Transaction(3, 25000.0, "Salary", "Monthly salary", Date(), TransactionType.INCOME)
                )
                
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun addTransaction(
        amount: Double,
        category: String,
        description: String,
        type: TransactionType
    ) {
        viewModelScope.launch {
            try {
                // For now, just refresh the data - database integration will be added later
                loadMonthlyData()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    
    fun refreshData() {
        loadMonthlyData()
    }
}
