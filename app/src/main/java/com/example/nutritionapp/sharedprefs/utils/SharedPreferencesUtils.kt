package com.example.nutritionapp.sharedprefs.utils

import android.content.SharedPreferences

fun SharedPreferences.getStringOrDefault(key: String, defaultValue: String): String {
    return this.getString(key, defaultValue) ?: defaultValue
}

fun SharedPreferences.getToken(): String {
    return this.getStringOrDefault("token", "")
}