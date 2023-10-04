package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.foodapp.ui.DetailsActivity
import com.example.foodapp.ui.FOOD_DETAILS_POS_KEY
import com.example.foodapp.ui.screens.HomePage
import com.example.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                HomePage() { pos ->
                    startActivity(Intent(this, DetailsActivity::class.java)
                        .apply {
                            putExtra(FOOD_DETAILS_POS_KEY, pos)
                        })
                }
            }
        }
    }
}