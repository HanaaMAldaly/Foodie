package com.example.foodapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.R
import com.example.foodapp.data.getCategories
import com.example.foodapp.data.getFood

@Preview
@Composable
fun HomeSection(onFoodItemClick: (Int) -> Unit = {}) {

    Surface() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
            // .padding(horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Food Category")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "See More",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_right),
                    contentDescription = "Right",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            }
            LazyRow(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                items(getCategories()) {
                    FoodCategoryItem(category = it)
                }

            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Food for you")
                Row(
                    modifier = Modifier
                        .width(40.dp)
                        .align(Alignment.CenterVertically),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        modifier = Modifier.size(10.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primary
                    ) {}
                    Surface(
                        modifier = Modifier.size(10.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.onBackground
                    ) {}

                    Surface(
                        modifier = Modifier.size(10.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.onBackground
                    ) {}
                }

            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(5.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                itemsIndexed(getFood()) { pos, item ->
                    FoodItem(food = item) {
                        onFoodItemClick.invoke(pos)
                    }
                }
            }
        }
    }
}
