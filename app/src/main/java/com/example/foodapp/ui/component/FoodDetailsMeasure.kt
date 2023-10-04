package com.example.foodapp.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun FoodDetailsMeasure(
    title: String,
    icon: Int,
    iconColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier.padding(5.dp),
            contentDescription = null,
            tint = iconColor
        )
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}