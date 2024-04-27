package com.example.nutritionapp.base.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(fragmentId: Int, args: Bundle? = null) {
    findNavController().navigate(fragmentId, args)
}

fun Fragment.navigateUp() {
    findNavController().navigateUp()
}