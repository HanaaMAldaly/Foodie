package com.example.foodapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.R
import com.example.foodapp.data.getFood
import com.example.foodapp.ui.component.FoodDetailsMeasure
import com.example.foodapp.ui.component.PriceBar

@Preview
@Composable
fun FoodDetails(
    foodId: Int = 0,
    onBackPressed: () -> Unit = {}
) {
    val food = getFood(foodId)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .paint(
                    painterResource(id = food.image),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            NavItem(
                icon = R.drawable.ic_back,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 32.dp, start = 16.dp)
                    .clickable { onBackPressed.invoke() }
            )
            NavItem(
                icon = R.drawable.ic_favorite,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 32.dp, start = 16.dp)
            )

        }
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 300.dp),
            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        top = 110.dp,
                        start = 16.dp, end = 16.dp
                    )
                    .horizontalScroll(rememberScrollState())
            ) {

                Text(
                    text = food.name,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.ExtraBold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FoodDetailsMeasure(
                        title = "${food.waitTime} mins",
                        icon = R.drawable.ic_clock,
                        iconColor = MaterialTheme.colorScheme.tertiary
                    )
                    Divider()
                    FoodDetailsMeasure(
                        title = "${food.calories} kal",
                        icon = R.drawable.ic_cal,
                        iconColor = MaterialTheme.colorScheme.primary
                    )
                    Divider()
                    FoodDetailsMeasure(
                        title = "${food.rating}/5", icon = R.drawable.ic_star,
                        iconColor = MaterialTheme.colorScheme.error
                    )

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .height(1.dp)
                        .background(MaterialTheme.colorScheme.onBackground)
                )
                PriceBar(food.price, food.originalPrice)
                Text(
                    text = "About Food",
                  //  modifier = Modifier.padding(top = 50.dp),
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = food.description,
                    modifier = Modifier.padding(top = 16.dp),
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 64.dp)
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(text = "Add to order ${food.price ?: food.originalPrice} each")

        }
        Surface(
            modifier = Modifier
                .padding(top = 150.dp)
                .size(250.dp)
                .background(
                    MaterialTheme.colorScheme.tertiary,
                    shape = CircleShape
                )
                .shadow(10.dp, shape = CircleShape)
                .border(
                    width = 4.dp, color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = food.image), contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun Divider() {
    Box(
        modifier = Modifier
            .size(8.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onBackground,
                shape = CircleShape
            )
    )
}

@Composable
fun NavItem(icon: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Icon(
            painter = painterResource(id = icon), contentDescription = "Nav",
            modifier = Modifier.align(Alignment.Center),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}