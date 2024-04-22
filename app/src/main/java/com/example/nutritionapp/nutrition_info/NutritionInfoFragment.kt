package com.example.nutritionapp.nutrition_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionapp.R

class NutritionInfoFragment : Fragment() {

    companion object {
        fun newInstance() = NutritionInfoFragment()
    }

    private lateinit var viewModel: NutritionInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nutrition_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NutritionInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}