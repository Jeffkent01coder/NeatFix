package com.jeff.neatfix.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jeff.neatfix.R

@Composable
fun SignUpOrLoginScreen(){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF180E36))
    ) {
        val(banner, logo, title, slogan, btnSignUp, btnLogin) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.movie_banner),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(banner) {
                }
                .fillMaxWidth(fraction = 0.5F),
            contentScale = ContentScale.Crop,
            contentDescription = "Movie Banner")

        Image(painter = painterResource(id = R.drawable.ic_logo),
            modifier = Modifier.constrainAs(logo){
                top.linkTo(banner.bottom)
                bottom.linkTo(banner.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            contentDescription = "App Logo")

        Text(
            text = "NeatFix",
            modifier = Modifier.constrainAs(title){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(logo.bottom, margin = 12.dp)
            },
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White.copy(alpha = 0.78F)
        )


        val welcomeText = "Access unlimited movies, series & TV shows anywhere, anytime"
        Text(
            text = welcomeText ,
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .constrainAs(slogan) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(
                        title.bottom,
                        margin = 12.dp
                    )
                },
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            color = Color.White.copy(alpha = 0.78F)
        )

        Button(onClick = { },
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .constrainAs(btnSignUp) {
                top.linkTo(slogan.bottom, margin = 12.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            ) {
            Text(text = "Sign Up" )

        }

        Button(onClick = { },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .constrainAs(btnLogin) {
                    top.linkTo(btnSignUp.bottom, margin = 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text(text = "Login in" )

        }

    }
}
@Preview(device = Devices.PIXEL)
@Composable
fun SignUpOrLoginPrev(){
    SignUpOrLoginScreen()
}