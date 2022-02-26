package com.jeff.neatfix.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun NextIcon(onClick:() -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(Color(0XFF423460))
            .size(42.dp)
        )
        {
            ConstraintLayout()
            {
                val (icon) = createRefs()
                Icon(imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Icon Next",
                    tint = Color.White.copy(alpha = 0.78F),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .constrainAs(icon) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .clickable { onClick() }

                )

            }

        }

    }
}
@Preview
@Composable
fun IconPrev(){
    NextIcon {

    }
}