package com.example.foodapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodapp.ui.component.BottomNavBar
import com.example.foodapp.ui.component.HomeSection
import com.example.foodapp.ui.component.ProfileBar
import com.example.foodapp.ui.component.SearchBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(onFoodItemClick: (Int) -> Unit = {}) {
    Scaffold(
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp),
        topBar = { ProfileBar() },
        bottomBar = { BottomNavBar() }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            SearchBar()
            HomeSection(onFoodItemClick)
        }
    }
}