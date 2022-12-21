package com.example.myorder.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myorder.R

@Composable
fun CustomImage(){
    Image(
        painterResource(id = R.drawable.dress),
        contentDescription ="Cart button icon",

                modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
            .width(90.dp)
            .height(90.dp)
            .padding(start = 20.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
    )
}