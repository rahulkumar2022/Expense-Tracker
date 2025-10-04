# Expense Tracker Android App

A modern, clean, and intuitive expense tracking Android application built with Jetpack Compose and Material Design 3 principles.

## 🎯 Features

### Core Functionality

- **Expense & Income Tracking**: Log daily expenses and income with categories
- **Category Management**: Pre-defined categories (Food, Travel, Shopping, Rent, etc.)
- **Visual Analytics**: Charts and insights for spending patterns
- **Monthly Summaries**: Track spending trends and budget management
- **Transaction History**: Complete transaction list with filtering and search

### UI/UX Features

- **Material Design 3**: Modern, clean interface with teal color scheme
- **Dark Mode Support**: Toggle between light and dark themes
- **Responsive Design**: Optimized for different screen sizes
- **Smooth Animations**: Engaging transitions and micro-interactions
- **Intuitive Navigation**: Bottom navigation with clear screen hierarchy

### Screens Included

1. **Splash Screen**: Animated logo with gradient background
2. **Login/Signup**: Google Sign-In, Email/Password, Guest mode
3. **Home Dashboard**: Summary cards, charts, recent transactions
4. **Add Expense**: Form with validation and category selection
5. **Transactions**: Filterable list with search functionality
6. **Insights**: Analytics with charts and spending insights
7. **Settings**: User profile, preferences, and app settings

## 🏗️ Architecture

### Tech Stack

- **UI**: Jetpack Compose with Material Design 3
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Room (SQLite)
- **Navigation**: Navigation Compose
- **State Management**: StateFlow and Compose State
- **Dependency Injection**: Manual DI (can be upgraded to Hilt)

### Project Structure

```
app/src/main/java/com/synergeticsciences/expensetracker/
├── data/
│   ├── database/          # Room database setup
│   ├── model/             # Data models
│   └── repository/        # Repository pattern
├── navigation/            # Navigation setup
├── notification/          # Notification system
├── ui/
│   ├── screens/           # All UI screens
│   ├── theme/             # Material Design 3 theme
│   └── viewmodel/         # ViewModels
├── MainActivity.kt        # Main activity
└── ExpenseTrackerApplication.kt
```

## 🎨 Design System

### Colors

- **Primary**: Teal (#009688)
- **Secondary**: Light Teal (#4DB6AC)
- **Accent**: Coral (#FF7043)
- **Success**: Green (#4CAF50)
- **Error**: Red (#F44336)
- **Background**: White/Light Gray

### Typography

- **Font**: Google Sans / Roboto
- **Hierarchy**: Clear text sizing and weight system

### Components

- **Cards**: Rounded corners with subtle shadows
- **Buttons**: Material Design 3 button styles
- **Icons**: Material Icons with consistent sizing
- **Charts**: Placeholder for MPAndroidChart integration

## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- Kotlin 1.8+
- Android SDK 26+ (Android 8.0)

### Installation

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run on device or emulator

### Dependencies

- Jetpack Compose BOM
- Navigation Compose
- Room Database
- Material Design 3
- Coroutines
- DataStore Preferences
- Work Manager (for notifications)

## 📱 App Flow

```
Splash Screen (3s)
    ↓
Login Screen
    ↓
Home Dashboard
    ├── Add Expense Screen
    ├── Transactions Screen
    ├── Insights Screen
    └── Settings Screen
```

## 🔧 Configuration

### Database

- Room database with automatic migrations
- Default categories pre-populated
- User-specific data isolation

### Notifications

- Daily expense reminders
- Weekly spending summaries
- Configurable notification preferences

### Theme

- Material Design 3 color scheme
- Dark mode support
- Consistent elevation and shadows

## 🎯 Future Enhancements

### Planned Features

- **Charts Integration**: MPAndroidChart for visual analytics
- **Budget Management**: Set and track monthly budgets
- **Data Export**: CSV/Excel export functionality
- **Cloud Sync**: Firebase integration for data backup
- **Advanced Analytics**: Spending trends and predictions
- **Receipt Scanning**: OCR for automatic expense entry
- **Multi-Currency**: Support for different currencies
- **Widgets**: Home screen widgets for quick access

### Technical Improvements

- **Dependency Injection**: Migrate to Hilt
- **Testing**: Unit and UI tests
- **Performance**: Optimize database queries and UI rendering
- **Accessibility**: Improve accessibility features
- **Localization**: Multi-language support

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📞 Support

For support and questions, please open an issue in the repository.

---

**Built with ❤️ using Jetpack Compose and Material Design 3**
# Expense-Tracker
