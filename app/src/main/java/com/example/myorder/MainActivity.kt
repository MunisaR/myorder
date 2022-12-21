package com.example.myorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myorder.addNew.AddNewItemScreen
import com.example.myorder.detailView.DetailedView
import com.example.myorder.list.ProductsList
import com.example.myorder.navigation.BottomNavItem
import com.example.myorder.settings.Settings
import com.example.myorder.ui.theme.MyOrderTheme
import com.example.myorder.ui.theme.Purple

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyOrderTheme {
//                    Navigation()
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                title = stringResource(id = R.string.navigation_home),
                                route = "productsList",
                                icon = Icons.Default.Home
                            ),
                            BottomNavItem(
                                title = stringResource(id = com.example.myorder.R.string.navigation_add),
                                route = "add",
                                icon = Icons.Default.Add
                            ),
                            BottomNavItem(
                                title = stringResource(id = com.example.myorder.R.string.navigation_settings),
                                route = "settings",
                                icon = Icons.Default.Settings
                            )
                        ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    )
                }) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "productsList"){
        composable("productsList") {
            ProductsList(
                onProductClick = { productId ->
                    navController.navigate("detailedView/$productId")
                }
            )
        }
        composable("add") {
            AddNewItemScreen()
                }
        composable("settings") {
            Settings()
        }
        composable(
            "detailedView/{productId}"
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("productId")?.let { DetailedView(it) }
        }
    }
}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
){
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Purple,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = item.title)
                        Text(
                            text = item.title,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp
                        )
                    }
                }
            )
        }
    }
}






