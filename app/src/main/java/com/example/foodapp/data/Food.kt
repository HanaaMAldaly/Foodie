package com.example.foodapp.data

import androidx.annotation.DrawableRes
import com.example.foodapp.R

data class Food(
    val name: String,
    val description: String,
    val price: Float?,
    val originalPrice: Float,
    val rating: Float,
    val calories: Int,
    val waitTime: Int,
    @DrawableRes val image: Int
)

fun getFood(pos: Int): Food = getFood()[pos]

fun getFood(): List<Food> {
    return listOf(
        Food(
            name = "Burger",
            price = null,
            originalPrice = 15.0f,
            rating = 4.3f,
            calories = 200,
            description = "A big juicy cheese burger.",
            waitTime = 20,
            image = R.drawable.food_burger
        ),
        Food(
            name = "English Breakfast",
            price = 17.99f,
            originalPrice = 25.0f,
            rating = 3.3f,
            calories = 150,
            description = "Get your day started well with some English breakfast",
            waitTime = 35,
            image = R.drawable.food_english_breakfast
        ),
        Food(
            name = "Watermelon",
            price = 3.0f,
            originalPrice = 4.99f,
            rating = 4.3f,
            calories = 200,
            description = "Watermelons are very healthy hydration mechanisms",
            waitTime = 8,
            image = R.drawable.food_melon
        ),
        Food(
            name = "Ramen",
            price = null,
            originalPrice = 12.0f,
            rating = 4.8f,
            calories = 125,
            description = "Some noodles to fuel the day ahead.",
            waitTime = 13,
            image = R.drawable.food_ramen
        ),
        Food(
            name = "Beef Steak",
            price = 15.99f,
            originalPrice = 19.99f,
            rating = 3.5f,
            calories = 210,
            description = "Sit down and relax, your steak is on the way.",
            waitTime = 20,
            image = R.drawable.food_beefsteak
        ),
    )
}