package com.example.myorder.addNew

import android.content.Context
import android.content.Intent
import android.service.autofill.OnClickAction
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.myorder.MainActivity
import com.example.myorder.R
import com.example.myorder.utils.CustomImage
import com.example.myorder.network.myResponse.MyResponse
import com.example.myorder.network.product.ProductRequest
import com.example.myorder.ui.theme.LightGrey
import com.example.myorder.ui.theme.Purple
import com.example.myorder.ui.theme.TextColor
import com.example.myorder.ui.theme.White

@Composable
fun AddNewItemScreen(
    viewModel: AddNewViewModel = AddNewViewModel()) {

    val context = LocalContext.current

    val brandValue = remember {
        mutableStateOf("")
    }

    val priceValue = remember {
        mutableStateOf("")
    }
    val descriptionValue = remember {
        mutableStateOf("")
    }

    val isProgressVisible = remember { mutableStateOf(false) }
    val response by viewModel.productInsertResponse.observeAsState()

    Box(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {
        Column {
            Header(sectionName = stringResource(id = R.string.add))
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .verticalScroll(rememberScrollState())
            ) {
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
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    text = stringResource(id = R.string.image)
                )
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )
                CustomImage()
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )
                DescriptionInput(descriptionValue = descriptionValue.value, onDescriptionChange ={descriptionValue.value = it} )
                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                )

                val validationMsg = stringResource(id = R.string.validation_msg)
                AddNewButton {
                    if (isInputValid(brandValue.value, descriptionValue.value, priceValue.value)) {
                        viewModel.saveNewProductToRemoteDb(
                            ProductRequest(
                                brandValue.value,
                                descriptionValue.value,
                                priceValue.value,
                            )
                        )
                        isProgressVisible.value = true
                    } else {
                        val toast = Toast.makeText(context, validationMsg, Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                }
            }
            response?.let { ProgressWidget(response = it, isVisible = isProgressVisible.value, context) }
            }
        }
    }

@Composable
private fun ProgressWidget(response: MyResponse, isVisible: Boolean, context: Context) {
    if (isVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Purple)
        ) {
            Text(
                modifier = Modifier
                    .background(Color.White)
                    .padding(20.dp)
                    .align(Alignment.Center),
                fontSize = 25.sp,
                text =
                if (response.status.isEmpty()) stringResource(id = R.string.in_progress_mgs) //by default status is "", so if it is empty that means network request hasn't returned a response yet
                else if (response.status == "OK") stringResource(id = R.string.saved_successfully_msg)
                else stringResource(id = R.string.failed_to_save_msg)
            )
        }
        context.startActivity(Intent(context, MainActivity::class.java))
    }
}

@Composable
private fun AddNewButton(onClick: () -> Unit) {

Row (modifier = Modifier
    .padding(start = 150.dp)) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .width(85.dp)
            .height(45.dp)
            .clip(RoundedCornerShape(18.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Purple)
    ) {
        Text(
            text = stringResource(id = R.string.save_button)
        )
    }
}
}

@Composable
fun BrandInput(brandValue: String, onNameChange: (String) -> Unit) {
    Text(
        modifier = Modifier
            .padding(start = 10.dp),
        fontSize = 16.sp,
        text = stringResource(id = R.string.brand),
        fontFamily = FontFamily.Monospace
    )
    Spacer(
        modifier = Modifier
            .height(8.dp)
    )
    TextField(
        modifier = Modifier
            .height(48.dp)
            .width(370.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(LightGrey),
        value = brandValue,
        onValueChange = { onNameChange(it) },
        label = {
            Text(
                stringResource(id = R.string.brand),
            )

        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Purple,
            focusedLabelColor = Purple,
            cursorColor = TextColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun PriceInput(priceValue:String, onPriceChange: (String) -> Unit){
    Text(
        modifier = Modifier
            .padding(start = 10.dp),
        fontSize = 16.sp,
        text = stringResource(id = R.string.price),
        fontFamily = FontFamily.Monospace
    )

    Spacer(
        modifier = Modifier
            .height(8.dp)
    )

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
    ) {
        TextField(
            modifier = Modifier
                .height(48.dp)
                .width(370.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(LightGrey),
            value = priceValue,
            onValueChange = { onPriceChange(it) },
            label = {
                Text(
                    stringResource(id =  R.string.price),
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple,
                focusedLabelColor = Purple,
                cursorColor = TextColor
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

    }
}

@Composable
fun DescriptionInput(descriptionValue : String, onDescriptionChange : (String) -> (Unit)){
    Column(
        Modifier
            .padding(start = 10.dp)
    ) {
        Text(modifier = Modifier
            .padding(start = 5.dp),
            text = stringResource(id = R.string.description),
            fontFamily = FontFamily.Monospace,
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        TextField(
            modifier = Modifier
                .height(50.dp)
                .width(370.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(LightGrey),
            value = descriptionValue,
            onValueChange = {onDescriptionChange(it)},
            label = {
                Text(
                    modifier = Modifier
                        .padding(start = 2.dp),
                    fontSize = 15.sp,
                    text = stringResource(id = R.string.description),
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple,
                focusedLabelColor = Purple,
                cursorColor = TextColor
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )
    }
}

@Composable
fun Header(
    sectionName: String = stringResource(id = R.string.add),
    icon: Int = R.drawable.search
){
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 20.dp,
                    bottomStart = 20.dp
                )
            )
            .background(Purple)
            .padding(15.dp)
            .width(400.dp)
            .height(30.dp)
    )
    {
        Text(modifier = Modifier
            .padding(top = 5.dp),
            text = sectionName,
            style = MaterialTheme.typography.h5,
            color = White,
            fontFamily = FontFamily.Monospace
        )
            Icon(
                painter = painterResource(id = icon),
                contentDescription = stringResource(id = R.string.save_button),
                tint = White,
                modifier = Modifier
                    .size(50.dp)
                    .padding(
                        start = 15.dp,
                        end = 10.dp
                    )
                    .clickable { }
            )
    }
}

private fun isInputValid(
    brandValue: String,
    descriptionValue: String,
    priceValue: String
): Boolean {
    if (brandValue.isBlank() || descriptionValue.isBlank()) return false

    if (priceValue.isBlank() || !priceValue.isDigitsOnly()) return false

    return true
}
