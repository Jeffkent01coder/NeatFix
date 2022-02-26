package com.jeff.neatfix.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeff.neatfix.R

@Composable
fun Home(){
    Column(modifier = Modifier
        .background(color = Color(0xFF180E36))
        .fillMaxSize()) {

        SearchBarAndProfileImage()
    }
}

@Composable
fun SearchBarAndProfileImage(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box (
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(0.82F)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Color((0XFF423460)),
                )
        )
        {
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(34.dp),
                    tint = Color.White.copy(alpha = 0.48F)

                )
            }

        }

        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp),
            contentScale = ContentScale.Crop,
            contentDescription ="Profile Image" )
    }
}

@Preview
@Composable
fun HomePrev(){
    Home()
}