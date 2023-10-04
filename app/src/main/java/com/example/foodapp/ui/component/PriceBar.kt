package com.example.foodapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PriceBar(price: Float? = 0.0f, originalPrice: Float = 5f) {
    var quantity by rememberSaveable { mutableStateOf(1) }
    Box(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Row {
            Text(
                text = "$${price ?: originalPrice}",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary
            )
            if (price != null) {
                Text(
                    text = "$$originalPrice",
                    modifier = Modifier.padding(start = 5.dp),
                    fontWeight = FontWeight.Medium,
                    textDecoration = TextDecoration.LineThrough
                )
            }
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(35.dp)
                    )
                    .clip(
                        RoundedCornerShape(35.dp)
                    )
                    .align(Alignment.CenterVertically)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FloatingActionButton(
                        onClick = { if (quantity > 0) quantity-- },
                        modifier = Modifier
                            .padding(5.dp)
                            .size(45.dp),
                        shape = CircleShape,
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_remove),
                            contentDescription = "Remove"
                        )
                    }
                    TextField(
                        value = "$quantity",
                        onValueChange = {
                            quantity = it.toInt()
                        },
                        modifier = Modifier.size(45.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            textColor = MaterialTheme.colorScheme.onTertiary

                        )
                    )
                    FloatingActionButton(
                        onClick = { quantity++ },
                        modifier = Modifier
                            .padding(5.dp)
                            .size(45.dp),
                        shape = CircleShape,
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
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
}