package com.colodin.mvicompose.product.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.colodin.mvicompose.R
import com.colodin.mvicompose.product.data.QAProductFull
import org.junit.Rule
import org.junit.Test

class ProductViewFullTest {

    @get:Rule(order = 0)
    val composeTestRule = createComposeRule()

    private val productFull by lazy { QAProductFull(id = 1, title = "title", description = "description", price = "$1.00", discountPercentage = "1.00%", rating = 5.00f, stock = "10", category = "category", images = emptyList()) }

    @Test
    fun test_ProductViewFull() {
        composeTestRule.setContent {
            ProductViewFull(productFull = productFull)
        }

        composeTestRule.onNodeWithText("title").assertIsDisplayed()
        composeTestRule.onNodeWithText("description").assertIsDisplayed()
        composeTestRule.onNodeWithText("Price").assertIsDisplayed()
        composeTestRule.onNodeWithText("$1.00").assertIsDisplayed()
        composeTestRule.onNodeWithText("category").assertIsDisplayed()
        composeTestRule.onNodeWithText("Category").assertIsDisplayed()

        composeTestRule.onNodeWithText("Discount").assertIsDisplayed()
        composeTestRule.onNodeWithText("1.00%").assertIsDisplayed()
        composeTestRule.onNodeWithText("Category").assertIsDisplayed()
        composeTestRule.onNodeWithText("10").assertIsDisplayed()

        Espresso.onView(ViewMatchers.withId(R.id.productShortRating)).check(ViewAssertions.matches(ratingBarMatcher(5f)))

    }

}