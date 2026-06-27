# RegistrationApp 📋

An Android application built as part of a developer assignment for **KidloLand (Formerly IDZ Digital)**.

## 📱 App Overview

A clean and professional Android registration app that allows users to register their information and view all registrations in a structured list.

## ✨ Features

- 🎬 **Splash Screen** with KidloLand branding
- 📝 **Registration Form** with Name, Date of Birth and Email
- 📅 **Calendar Date Picker** for easy date selection
- ✅ **Form Validation** with error messages
- 💾 **SQLite Database** for local data storage
- 📋 **Registration List** showing all registered users as cards
- 🗑️ **Delete** individual registrations with trash icon
- 🚪 **Back button** exits the app cleanly
- 🎨 **Clean white professional UI** throughout

## 🛠️ Tech Stack

| Category | Technology |
|----------|-----------|
| Language | Java |
| Database | SQLite |
| IDE | Android Studio |
| Min SDK | API 24 (Android 7.0) |
| UI | XML Layouts |

## 📂 Project Structure

app/
├── java/com/example/registrationapp/
│   ├── SplashActivity.java      # Splash screen
│   ├── MainActivity.java        # Registration form
│   ├── SecondActivity.java      # Display registered users
│   └── DatabaseHelper.java      # SQLite operations
└── res/
    └── layout/
        ├── activity_splash.xml
        ├── activity_main.xml
        └── activity_second.xml

## 🚀 How It Works

1. App opens with **KidloLand splash screen**
2. User fills in **Name, DOB and Email** in the form
3. Clicking **Submit** saves data to SQLite database
4. App navigates to **Registrations screen**
5. All users shown as **clean white cards**
6. Each card has a **🗑 delete icon** to remove entry
7. Pressing back **exits the app**

## 📸 Screens

| Splash | Registration Form | Registrations List |
|--------|------------------|-------------------|
| KidloLand Logo | Form with fields | User cards with delete |

## 📦 APK

The debug APK is available at:
app/build/outputs/apk/debug/app-debug.apk

## 👨‍💻 Developer

**Aditya Kunchikorve**
- GitHub: [@kunchikorveaditya97-create](https://github.com/kunchikorveaditya97-create)

