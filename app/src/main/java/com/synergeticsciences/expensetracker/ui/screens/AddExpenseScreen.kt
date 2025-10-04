package com.synergeticsciences.expensetracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.synergeticsciences.expensetracker.data.model.TransactionType
import com.synergeticsciences.expensetracker.ui.theme.*
import java.text.NumberFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(
    onNavigateBack: () -> Unit,
    onSaveTransaction: (amount: Double, category: String, description: String, date: String, type: TransactionType) -> Unit
) {
    var amount by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Food") }
    var description by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("Today") }
    var transactionType by remember { mutableStateOf(TransactionType.EXPENSE) }
    var showSnackbar by remember { mutableStateOf(false) }
    var snackbarMessage by remember { mutableStateOf("") }
    
    val categories = listOf(
        "Food", "Travel", "Shopping", "Rent", "Entertainment",
        "Healthcare", "Transportation", "Education", "Utilities", "Other"
    )
    
    val currencyFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top App Bar
        TopAppBar(
            title = {
                Text(
                    text = if (transactionType == TransactionType.EXPENSE) "Add Expense" else "Add Income",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Transaction Type Toggle
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Transaction Type",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            onClick = { transactionType = TransactionType.EXPENSE },
                            label = { Text("Expense") },
                            selected = transactionType == TransactionType.EXPENSE,
                            modifier = Modifier.weight(1f)
                        )
                        FilterChip(
                            onClick = { transactionType = TransactionType.INCOME },
                            label = { Text("Income") },
                            selected = transactionType == TransactionType.INCOME,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
            
            // Amount Input
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Amount",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    OutlinedTextField(
                        value = amount,
                        onValueChange = { amount = it },
                        label = { Text("Enter amount") },
                        leadingIcon = {
                            Icon(Icons.Default.Paid, contentDescription = "Amount")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        isError = amount.isNotEmpty() && amount.toDoubleOrNull() == null
                    )
                    
                    if (amount.isNotEmpty() && amount.toDoubleOrNull() != null) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Preview: ${currencyFormat.format(amount.toDouble())}",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
            
            // Category Selection
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Category",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    var expanded by remember { mutableStateOf(false) }
                    
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = selectedCategory,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Select category") },
                            leadingIcon = {
                                Icon(Icons.Default.Category, contentDescription = "Category")
                            },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor()
                        )
                        
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            categories.forEach { category ->
                                val categoryColor = when (category) {
                                    "Food" -> FoodColor
                                    "Travel" -> TravelColor
                                    "Shopping" -> ShoppingColor
                                    "Rent" -> RentColor
                                    "Entertainment" -> EntertainmentColor
                                    "Healthcare" -> HealthcareColor
                                    "Transportation" -> TransportationColor
                                    "Education" -> EducationColor
                                    "Utilities" -> UtilitiesColor
                                    else -> OtherColor
                                }
                                
                                DropdownMenuItem(
                                    text = { 
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(12.dp)
                                                    .background(
                                                        categoryColor,
                                                        shape = androidx.compose.foundation.shape.CircleShape
                                                    )
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(category)
                                        }
                                    },
                                    onClick = {
                                        selectedCategory = category
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
            
            // Date Selection
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Date",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    OutlinedTextField(
                        value = selectedDate,
                        onValueChange = { selectedDate = it },
                        label = { Text("Select date") },
                        leadingIcon = {
                            Icon(Icons.Default.CalendarToday, contentDescription = "Date")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        readOnly = true
                    )
                }
            }
            
            // Description
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Description",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Add notes (optional)") },
                        leadingIcon = {
                            Icon(Icons.Default.Description, contentDescription = "Description")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 3
                    )
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = onNavigateBack,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancel")
                }
                
                Button(
                    onClick = {
                        val amountValue = amount.toDoubleOrNull()
                        if (amountValue != null && amountValue > 0) {
                    onSaveTransaction(
                        amountValue,
                        selectedCategory,
                        description,
                        selectedDate,
                        transactionType
                    )
                            snackbarMessage = "${transactionType.name} added successfully!"
                            showSnackbar = true
                            onNavigateBack()
                        }
                    },
                    modifier = Modifier.weight(1f),
                    enabled = amount.toDoubleOrNull() != null && amount.toDoubleOrNull()!! > 0
                ) {
                    Text("Save")
                }
            }
        }
    }
    
    // Snackbar
    if (showSnackbar) {
        LaunchedEffect(showSnackbar) {
            kotlinx.coroutines.delay(2000)
            showSnackbar = false
        }
    }
}
