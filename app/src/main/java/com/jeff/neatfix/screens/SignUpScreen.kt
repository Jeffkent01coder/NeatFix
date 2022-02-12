package com.jeff.neatfix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF180E36))) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back icon",
                tint = Color.White.copy(alpha = 0.78F)
            )
            Text(text = "Create Account",
            modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White.copy(alpha = 0.78F)
                )

        }

    }

}

@Preview(device = Devices.PIXEL)
@Composable
fun SignUpScreenPrev(){
    SignUpScreen()
}