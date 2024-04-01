package com.example.nutritionapp.sharedprefs.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.nutritionapp.sharedprefs.model.SharedPrefs
import com.example.nutritionapp.sharedprefs.model.SharedPrefsType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    private const val APP_PREFERENCES = "APP_PREFERENCES"
    private const val APP_ENCRYPTED_PREFERENCES = "APP_ENCRYPTED_PREFERENCES"

    @SharedPrefs(SharedPrefsType.DEFAULT)
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
    }

    @SharedPrefs(SharedPrefsType.ENCRYPTED)
    @Provides
    fun provideEncryptedSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        val keyGenScheme = MasterKey.KeyScheme.AES256_GCM
        val mainKey = MasterKey.Builder(context)
            .setKeyScheme(keyGenScheme)
            .build()

        return EncryptedSharedPreferences.create(
            context,
            APP_ENCRYPTED_PREFERENCES,
            mainKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}