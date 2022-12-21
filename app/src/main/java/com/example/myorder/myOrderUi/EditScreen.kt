package com.example.myorder.myOrderUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myorder.addNew.*
import com.example.myorder.utils.CustomImage
import com.example.myorder.list.ListViewModel
import com.example.myorder.ui.theme.*

@Preview
@Composable
fun EditScreen(
    onProductClick: (String) -> Unit = {},
    viewModel: ListViewModel = ListViewModel()
) {
    val brandValue = remember {
        mutableStateOf("")
    }

    val imageValue = remember {
        mutableStateOf("")
    }
    val priceValue = remember {
        mutableStateOf("")
    }
    val descriptionValue = remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {
        Column {
            Header(sectionName = "Edit")
            BrandInput(brandValue = brandValue.value, onNameChange = { brandValue.value = it })
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            PriceInput(priceValue = priceValue.value, onPriceChange = {priceValue.value = it})
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            CustomImage()
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            DescriptionInput(descriptionValue = descriptionValue.value, onDescriptionChange ={descriptionValue.value = it} )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
        }
    }
}