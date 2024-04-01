package com.example.nutritionapp.sharedprefs.model

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SharedPrefs(val type: SharedPrefsType)

enum class SharedPrefsType {
    DEFAULT,
    ENCRYPTED
}