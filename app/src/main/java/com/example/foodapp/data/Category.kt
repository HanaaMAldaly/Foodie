package com.example.foodapp.data

import androidx.annotation.DrawableRes
import com.example.foodapp.R

data class Category(
    val name: String,
    @DrawableRes val image: Int
)


fun getCategories(): List<Category> {
    return listOf(
        Category(name = "Beverages", image = R.drawable.ic_beverages),
        Category(name = "Fast Food", image = R.drawable.ic_fast_food),
        Category(name = "Fruits", image = R.drawable.ic_fruits),
        Category(name = "Pastries", image = R.drawable.ic_pastries),
        Category(name = "Salads", image = R.drawable.ic_salads),
        Category(name = "Sea Food", image = R.drawable.ic_sea_food),
        Category(name = "Others", image = R.drawable.ic_others),
    )
}