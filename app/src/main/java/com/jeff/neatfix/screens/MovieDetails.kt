package com.jeff.neatfix.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jeff.neatfix.R
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MovieDetails() {
    val movieGenres = remember {
        mutableListOf("SCi-fi", "Drama", "Action")
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF180E36))
    ) {
        val (
            headerImage,
            backButton,
            movieGenreChips,
            descriptionText,
            cast,
            castTitle,
            movieTitleBox,
            MoviePosterImage,
            translucentBar,
            rating
        ) = createRefs()
        Image(painter = painterResource(id = R.drawable.stvstrange),
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .fillMaxHeight(0.33F)
                .constrainAs(headerImage) {
                    top.linkTo(parent.top)
                }
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            contentDescription = "header Image")
        Icon(
            imageVector = Icons.Default.ArrowBack,
            tint = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .background(shape = CircleShape, color = Color(0XFF423460).copy(alpha = 0.78F))
                .constrainAs(backButton) {
                    top.linkTo(headerImage.top)
                    start.linkTo(headerImage.start)
                },
            contentDescription = "back Button"
        )
        Spacer(modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        Color(0XFF180E36).copy(alpha = 0.5F),
                        Color(0XFF180E36)
                    ),
                    startY = 0F
                )
            )
            .constrainAs(translucentBar) {
                bottom.linkTo(headerImage.bottom)
            }
        )
        Image(
            painter = painterResource(id = R.drawable.stranget),
            modifier = Modifier
                .padding(16.dp)
                .height(195.dp)
                .width(130.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .constrainAs(MoviePosterImage) {
                    top.linkTo(headerImage.bottom)
                    bottom.linkTo(headerImage.bottom)
                },
            contentDescription = null
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .constrainAs(movieGenreChips) {
                    top.linkTo(castTitle.bottom, margin = 4.dp)
                }
        ) {
            movieGenres.forEach { text ->
                item {
                    GenreChips(genre = text)
                }

            }

        }
        Text(
            text = "Welcome to the Multiverse. Where Magic is power",
            color = White,
            modifier = Modifier.constrainAs(descriptionText){
                       top.linkTo(MoviePosterImage.bottom)
            }

                .fillMaxWidth()
                .padding(4.dp)
        )

        Text(
            modifier = Modifier
                .constrainAs(castTitle){
                    top.linkTo(descriptionText.bottom)
                }
                .padding(4.dp),
            text = "Cast",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = White

        )

        LazyRow(
            modifier = Modifier
                .constrainAs(cast){
                    top.linkTo(movieGenreChips.bottom)
                }
                .fillMaxWidth()
        )
        {
            items(count = 10) {
                Cast(image = R.drawable.strange, name = "Jeff", role = "Actor")
            }

        }
    }
}

@Composable
fun GenreChips(genre: String) {
    Box(
        modifier = Modifier
            .padding(end = 4.dp)
            .widthIn(min = 80.dp)
            .clip(CircleShape)
            .background(Color(0XFF423460))
            .padding(4.dp),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = genre,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,

            )
    }
}

@Composable
fun Cast(
    image: Int,
    name: String,
    role: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)

    ) {
        CoilImage(
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp),
            imageModel = image,
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = White,
                durationMillis = 350,
                dropOff = 0.65F,
                tilt = 20F
            ),
            previewPlaceholder = R.drawable.strange,
            contentScale = ContentScale.Crop,
            circularReveal = CircularReveal(duration = 1000)
        )
        Text(
            text = name,
            modifier = Modifier
                .padding(vertical = 4.dp),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = White
        )
        Text(
            text = role,
            modifier = Modifier
                .padding(bottom = 4.dp),
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = White

        )


    }

}


@Preview
@Composable
fun MovieDetailsPrev() {
    MovieDetails()
}
