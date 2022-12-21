package com.example.myorder.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myorder.addNew.Header
import com.example.myorder.utils.CustomImage
import com.example.myorder.model.Product
import com.example.myorder.myOrderUi.CategorySection
import com.example.myorder.ui.theme.LightGrey

@Preview
@Composable
fun ProductsList(
    onProductClick: ( String ) -> Unit = {},
    viewModel: ListViewModel = ListViewModel()
) {
    Header(sectionName = "Home", icon = com.example.myorder.R.drawable.search)
    Column(
        modifier = Modifier
            .padding(
                start = 23.dp,
                top = 100.dp,

            )
    ) {

   Column{
       CategorySection()

       Box(modifier = Modifier.fillMaxSize()) {
           val product by viewModel.productsLiveData.observeAsState()

           LazyColumn(
               modifier = Modifier
                   .fillMaxHeight()
                   .background(
                       colorResource(com.example.myorder.R.color.white)
                   )
                   .padding(0.dp, 0.dp, 0.dp, 50.dp),
           ) {
               product?.let {
                   items(items = it.toList(), itemContent = { item ->
                       ProductItem(product = item, onProductClick)
                   })
               }
           }
       }
   }
    }
}


@Composable
fun ProductItem(product: Product, onProductClick: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 30.dp, 40.dp, 0.dp)

    ) {
        Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(LightGrey)
            .width(350.dp)
            .height(94.dp)
            .clickable {
                onProductClick(product.id.toString())
            },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomImage()
            Spacer(modifier = Modifier
                .width(5.dp))
        Column(

          modifier = Modifier
            .padding(start = 10.dp, end = 0.dp, top = 0.dp, bottom = 10.dp)
        )
            {
                Brand(brand = product.title)
                Spacer(modifier = Modifier
                    .height(8.dp))
                Description(description = product.description)
            }
        }
    }
}


@Composable
private fun Brand(brand: String) {
      Text(
          text = brand,
          color = Color.Black,
          fontSize = 25.sp,
          fontFamily = FontFamily.Serif,
          textAlign = TextAlign.Center
      )
}

@Composable
private fun Description(description: String) {
       Text(
            text = description,
            color = Color.DarkGray,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif
       )
}