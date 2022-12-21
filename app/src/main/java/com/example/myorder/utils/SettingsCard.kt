package com.example.myorder.utils


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myorder.ui.theme.LightPurple
import com.example.myorder.ui.theme.Purple

@Composable
fun SettingsCard () {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 120.dp, 40.dp, 0.dp)
        ){
            Profile()
            Spacer(modifier = Modifier
                .height(40.dp))
            Premium()
            Spacer(modifier = Modifier
                .height(40.dp))
            Notification()
            Spacer(modifier = Modifier
                .height(40.dp))
            Filters()

        }
    }


@Composable
private fun Profile() {
    Card(
        shape = RoundedCornerShape(16.dp), elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable{}

    ) {
        Row(
            modifier = Modifier
                .padding(start = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = com.example.myorder.R.drawable.user_solid),
                contentDescription = "Profile",
                tint = Purple,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
            Text(
                text = stringResource(id = com.example.myorder.R.string.profile),
                color = LightPurple,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
private fun Premium() {
    Card(
        shape = RoundedCornerShape(16.dp), elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable{}


    ) {
        Row(
            modifier = Modifier
                .padding(start = 30.dp)
                .clip(RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = com.example.myorder.R.drawable.star_solid),
                contentDescription = "Premium",
                tint = Purple,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
            Text(
                text = stringResource(id = com.example.myorder.R.string.premium),
                color = LightPurple,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
private fun Notification() {
    Card(
        shape = RoundedCornerShape(16.dp), elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable{}
    ) {
        Row(
            modifier = Modifier
                .padding(start = 30.dp)
                .clip(RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = com.example.myorder.R.drawable.bell_solid),
                contentDescription = "Notifications",
                tint = Purple,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
            Text(
                text = stringResource(id = com.example.myorder.R.string.notifications),
                color = LightPurple,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        }
    }
}
@Composable
private fun Filters() {
    Card(
        shape = RoundedCornerShape(16.dp), elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable{}


    ) {
        Row(
            modifier = Modifier
                .padding(start = 30.dp)
                .clip(RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = com.example.myorder.R.drawable.sliders_solid),
                contentDescription = "Notifications",
                tint = Purple,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
            Text(
                text = stringResource(id = com.example.myorder.R.string.filters),
                color = LightPurple,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        }
    }
}