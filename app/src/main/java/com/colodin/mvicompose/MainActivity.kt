package com.colodin.mvicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.colodin.mvicompose.product.domain.ProductAction
import com.colodin.mvicompose.product.presentation.ProductView
import com.colodin.mvicompose.product.presentation.ProductViewFull
import com.colodin.mvicompose.product.presentation.ProductViewFullScreen
import com.colodin.mvicompose.product.presentation.ProductViewModel
import com.colodin.mvicompose.ui.theme.MVIComposeTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVIComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavigationView()
                }
            }
        }
    }
}

@Composable
fun NavigationView(productViewModel: ProductViewModel = koinViewModel()) {
    val navController = rememberNavController()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(key1 = productViewModel) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
            // is ok even in CREATED, anyway dispatch event will start on STARTED
            productViewModel.dispatch(ProductAction.ProductActionInit)
        }
    }

    NavHost(navController = navController, startDestination = "products") {
        composable("products") { ProductView() {
            navController.navigate("productViewFull")
        } }
        composable("productViewFull") { ProductViewFullScreen() }
    }
}
