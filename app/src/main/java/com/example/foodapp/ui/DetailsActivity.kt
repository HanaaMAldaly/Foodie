package com.example.foodapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.foodapp.ui.screens.FoodDetails
import com.example.foodapp.ui.ui.theme.FoodAppTheme

const val FOOD_DETAILS_POS_KEY = "food_details_pos"

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                FoodDetails(
                    intent.extras?.getInt(FOOD_DETAILS_POS_KEY) ?: 0
                ){
                    finish()
                }
            }
        }
    }
}