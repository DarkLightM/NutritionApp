package com.example.nutritionapp.base.utils

import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(fragmentId: Int) {
    findNavController().navigate(fragmentId)
}

fun Fragment.navigateUp() {
    findNavController().navigateUp()
}