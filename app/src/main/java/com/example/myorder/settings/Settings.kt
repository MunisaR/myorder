package com.example.myorder.settings


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myorder.R
import com.example.myorder.addNew.Header
import com.example.myorder.utils.SettingsCard

@Preview
@Composable
fun Settings(){
    Header(sectionName = "Settings", icon = R.drawable.search)
    Spacer(modifier = Modifier
        .height(30.dp))
    SettingsCard()
}