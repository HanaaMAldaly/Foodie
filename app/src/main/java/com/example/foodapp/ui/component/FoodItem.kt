package com.example.foodapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodapp.R
import com.example.foodapp.data.Food

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItem(food: Food, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .width(200.dp)
            .padding(end = 8.dp),
        shape = RoundedCornerShape(CornerSize(10.dp))
    ) {
        Image(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            painter = painterResource(id = food.image), contentDescription = food.name,
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = food.name,
                style = MaterialTheme.typography.bodyLarge,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.ExtraBold
            )
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "Clock",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                )
                Text(
                    text = "${food.waitTime} mins",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 3.dp)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${food.originalPrice}",
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.bodyLarge
                )

                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.tertiary
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add"
                    )
                }

            }
        }
    }
}
