package com.example.myorder.detailView

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myorder.addNew.Header
import com.example.myorder.ui.theme.TextColor

@Composable
fun DetailedView(productId: String, viewModel: DetailedViewModel = DetailedViewModel(productId)) {

    val product by viewModel.productLiveData.observeAsState()

    if (product != null) {
        Column{
            Header(sectionName = stringResource(id = com.example.myorder.R.string.details))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.padding(20.dp))
                    CustomImage()
                    Spacer(Modifier.height(15.dp))
                    Brand(brand = product!!.title)
                    Spacer(Modifier.height(16.dp))
                    Description(description = product!!.description)
                    Spacer(Modifier.height(16.dp))
                    Price(price = product!!.price)
                }
            }
        }
        }

}
@Composable
private fun Brand(brand: String) {
    Text(
        text = "$brand",
        color = Color.Black,
        fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Price(price: String){
    Text(
        text = "Price:   $ $price",
        fontSize = 25.sp,
        color = Color.Black,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
    )
}

@Composable
private fun CustomImage(){
    Image(
        painterResource(id = com.example.myorder.R.drawable.dress),
        contentDescription ="Dress",
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(180.dp)
                    .height(180.dp)
    )
}

@Composable
private fun Description(description: String){
    Text(
        text = description,
        style = MaterialTheme.typography.body2,
        color = TextColor,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )
}
