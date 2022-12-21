package com.example.myorder.myOrderUi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myorder.ui.theme.*

@Composable
fun CategorySection() {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(LightGrey)
            .width(350.dp)
            .height(56.dp)
    ) {
        Icon(painter = painterResource(id = com.example.myorder.R.drawable.t_shirt),
            contentDescription = "T-shirt",
            tint = White,
            modifier = Modifier
                .size(40.dp)
                .padding(start = 5.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Purple)
                .clickable { }
        )
        Icon(painter = painterResource(id = com.example.myorder.R.drawable.hoodie),
            contentDescription = "Hoodie",
            tint = TextColor,
            modifier = Modifier
                .size(35.dp)
                .clickable { }

        )
        Icon(painter = painterResource(id = com.example.myorder.R.drawable.longsliv),
            contentDescription = "Sweatshirt",
            tint = TextColor,
            modifier = Modifier
                .size(30.dp)
                .clickable { }

        )
        Icon(painter = painterResource(id = com.example.myorder.R.drawable.socks),
            contentDescription = "Socks",
            tint = TextColor,
            modifier = Modifier
                .size(32.dp)
                .clickable { }

        )
        Icon(painter = painterResource(id = com.example.myorder.R.drawable.t_shirt),
            contentDescription = "T-shirt",
            tint = TextColor,
            modifier = Modifier
                .size(35.dp)
                .clickable { }

        )
        Icon(painter = painterResource(id = com.example.myorder.R.drawable.longsliv),
            contentDescription = "Sweatshirt",
            tint = TextColor,
            modifier = Modifier
                .size(35.dp)
                .padding(end = 5.dp)
                .clickable { }

        )
    }
}
