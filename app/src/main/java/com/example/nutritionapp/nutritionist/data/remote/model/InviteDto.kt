package com.example.nutritionapp.nutritionist.data.remote.model

import com.google.gson.annotations.SerializedName

data class InviteDto (
    @SerializedName("nutritionist_id")
    val nutritionistId: Int,
)