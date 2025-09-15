package com.colodin.mvicompose.product.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.colodin.mvicompose.AppModuleTest
import com.colodin.mvicompose.AppProcessorAction
import com.colodin.mvicompose.R
import com.colodin.mvicompose.TestApplication
import com.colodin.mvicompose.app.domain.AppController
import com.colodin.mvicompose.app.domain.AppReducer
import com.colodin.mvicompose.app.domain.AppState
import com.colodin.mvicompose.product.ProductModule
import com.colodin.mvicompose.product.data.QAProductShort
import com.colodin.mvicompose.product.domain.ProductAction
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

class ProductViewTest: KoinComponent {

    @get:Rule(order = 0)
    val composeTestRule = createComposeRule()


    private val appController: AppController by inject()
    private val productReducer: AppReducer by inject()
    private val appProcessorAction: AppProcessorAction by inject()


    private val templateProductShort by lazy {
        QAProductShort(id  = 1, title = "title", price = "$1.00", rating = 4f, thumbnail = "https://test.com")
    }

    private fun changeState(appState: AppState) = runBlocking {
        launch(Dispatchers.Main) {
            appController.state.value = appState
        }
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
    fun testProductView() {

        composeTestRule.setContent {
            ProductView(productViewModel = ProductViewModel(appController)) {

            }
        }

        changeState(productReducer.reduce(ProductResult.ProductResultItems(listOf(templateProductShort)),appController.state.value!!))
        composeTestRule.onRoot().assertIsDisplayed()
        composeTestRule.onNodeWithText("title").assertIsDisplayed()
        composeTestRule.onNodeWithText("$1.00").assertIsDisplayed()
        Espresso.onView(ViewMatchers.withId(R.id.productShortRating)).check(ViewAssertions.matches(ratingBarMatcher(4f)))

        composeTestRule.onNodeWithText("title").performClick()
        assert(appProcessorAction.actions.count() == 1)
        assert(appProcessorAction.actions.last() is ProductAction.ProductActionFullProduct)

        val onProductActionFullProduct = appProcessorAction.actions.last() as ProductAction.ProductActionFullProduct
       assert(onProductActionFullProduct.productId == 1)
    }

    @Test
    fun testCircularProgressIndicator() {
        composeTestRule.setContent {
            ProductView {

            }
        }
        changeState(productReducer.reduce(ProductResult.ProductResultProductShowProgress(true),appController.state.value!!))
        composeTestRule.onNodeWithTag("circularProgressIndicator").assertIsDisplayed()
    }
}