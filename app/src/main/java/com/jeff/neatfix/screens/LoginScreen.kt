package com.jeff.neatfix.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeff.neatfix.R
import com.jeff.neatfix.composables.NextIcon

@Composable
fun LoginScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF180E36)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .padding(horizontal = 12.dp, vertical = 24.dp)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back icon",
                tint = Color.White.copy(alpha = 0.78F)
            )
            Text(text = "Welcome Back",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White.copy(alpha = 0.78F)
            )

        }

        Image(painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            modifier = Modifier.padding(vertical = 12.dp)
        )


        var inputEmail by remember{ mutableStateOf("") }
        var passwordInput by  remember{ mutableStateOf("") }
        var confirmPasswordInput by remember{ mutableStateOf("") }
        var isPasswordVisible by remember{ mutableStateOf(false) }

        val color = Color.White.copy(alpha = 0.78F)
        val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = color,
            cursorColor = color,
            leadingIconColor = color,
            trailingIconColor = color,
            focusedBorderColor = Color.White,
            unfocusedBorderColor = color.copy(alpha = 0.5F),
            focusedLabelColor = Color.White,
            unfocusedLabelColor = color
        )

        OutlinedTextField(
            value = inputEmail,
            onValueChange = { newValue ->
                inputEmail = newValue
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 12.dp),
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Icon")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = textFieldColors
        )

        OutlinedTextField(
            value = passwordInput,
            onValueChange = { newValue ->
                passwordInput = newValue
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 12.dp),
            label = {
                Text(text = "PassWord")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Icon")
            },
            trailingIcon = {
                val image = if (isPasswordVisible)
                    R.drawable.ic_baseline_visibility_24 else R.drawable.ic_baseline_visibility_off_24
                IconButton(onClick = {
                    isPasswordVisible =! isPasswordVisible
                }) {
                    Icon(painter = painterResource(id = image), contentDescription = "Toggle Icon" )
                }
            },
            singleLine = true,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = textFieldColors
        )



        NextIcon( onClick = {

        })






    }

}

@Composable
@Preview(device = Devices.PIXEL)
fun LoginPrev(){
    LoginScreen()
}