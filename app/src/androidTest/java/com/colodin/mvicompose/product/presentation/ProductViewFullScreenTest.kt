package com.colodin.mvicompose.product.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import com.colodin.mvicompose.AppModuleTest
import com.colodin.mvicompose.AppProcessorAction
import com.colodin.mvicompose.TestApplication
import com.colodin.mvicompose.app.domain.AppController
import com.colodin.mvicompose.app.domain.AppReducer
import com.colodin.mvicompose.app.domain.AppState
import com.colodin.mvicompose.product.ProductModule
import com.colodin.mvicompose.product.data.QAProductFull
import com.colodin.mvicompose.product.data.QAProductShort
import com.colodin.mvicompose.product.domain.ProductResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext

class ProductViewFullScreenTest: KoinComponent {
    @get:Rule(order = 0)
    val composeTestRule = createComposeRule()

    private val appController: AppController by inject()
    private val productReducer: AppReducer by inject()

    private val productFull by lazy { QAProductFull(id = 1, title = "title", description = "description", price = "$1.00", discountPercentage = "1.00%", rating = 5.00f, stock = "10", category = "category", images = emptyList()) }

    private fun changeState(appState: AppState) = runBlocking {
        val job = launch(Dispatchers.Main) {
            appController.state.value = appState
        }
        job.join()
    }

    @Before
    fun setUp() {
        GlobalContext.startKoin {
            androidContext(ApplicationProvider.getApplicationContext<TestApplication>())
            modules(
                AppModuleTest,
                ProductModule,
            )
        }
    }

    @After
    fun tearDown() {
        GlobalContext.stopKoin()
    }

    @Test
    fun isCircularProgressIndicator_show() {
        composeTestRule.setContent {
            ProductViewFullScreen(productViewModel = ProductViewModel(appController))
        }
        changeState(productReducer.reduce(ProductResult.ProductResultProductShowProgress(true),appController.state.value!!))
        composeTestRule.onNodeWithTag("circularProgressIndicator").assertIsDisplayed()
    }

    @Test
    fun is_show_full_product() {
        composeTestRule.setContent {
            ProductViewFullScreen(productViewModel = ProductViewModel(appController))
        }
        changeState(productReducer.reduce(ProductResult.ProductResultFullProduct(productFull),appController.state.value!!))
        composeTestRule.onNodeWithText("title").assertIsDisplayed()
        composeTestRule.onNodeWithText("description").assertIsDisplayed()
    }
}