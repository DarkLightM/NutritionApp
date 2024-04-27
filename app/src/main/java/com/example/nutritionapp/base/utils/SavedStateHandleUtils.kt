package com.example.nutritionapp.base.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

const val PARAMS_TAG = "parameter"
const val ARGUMENTS_CAPACITY = 1
inline fun <reified T> SavedStateHandle.requireArguments(): T {
    val stringValue = requireNotNull(get<String>(PARAMS_TAG))
    return Json.decodeFromString(stringValue)
}

inline fun <reified T> SavedStateHandle.getArgumentsOrNull(): T? {
    val stringValue = get<String>(PARAMS_TAG)
    return stringValue?.let { Json.decodeFromString(it) }
}

inline fun <T : Fragment, reified P> T.withArguments(args: P): T {
    arguments = Bundle(ARGUMENTS_CAPACITY).apply {
        putString(PARAMS_TAG, Json.encodeToString(args))
    }
    return this
}