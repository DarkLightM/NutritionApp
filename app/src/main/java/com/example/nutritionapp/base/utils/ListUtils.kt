package com.example.nutritionapp.base.utils

import com.example.nutritionapp.nutrition.domain.model.Nutrition

fun Nutrition.toList(): List<String> {
    return listOf(
        "Название: $name",
        "Калории: $calories",
        "Размер порции: $servingSize гр",
        "Общее количество жиров: $fatTotal гр",
        "Насыщенные жиры: $fatSaturated гр",
        "Белок: $protein гр",
        "Натрий: $sodium мкг",
        "Калий: $potassium мкг",
        "Холестерин: $cholesterol мкг",
        "Углеводы: $carbohydrates гр",
        "Волокна: $fiber гр",
        "Сахар: $sugar гр"
    )
}