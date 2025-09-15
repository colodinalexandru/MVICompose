package com.colodin.mvicompose.product.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import com.colodin.mvicompose.R
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.colodin.mvicompose.product.data.QAProductShort
import org.junit.Rule
import org.junit.Test

class ProductItemTest {

    @get:Rule(order = 0)
    val composeTestRule = createComposeRule()


    private val templateQAProductShort by lazy {
        QAProductShort(id = 1, title = "Product title", price = "$1", rating = 5f, thumbnail = "")
    }

    @Test
    fun test_all_properties_show() {

        var methodCallBackValue:QAProductShort? = null
        composeTestRule.setContent {
            ProductItem(templateQAProductShort) {
                methodCallBackValue = it
            }
        }

        composeTestRule.onNodeWithText("Product title").assertIsDisplayed()
        composeTestRule.onNodeWithText("$1").assertIsDisplayed()
        Espresso.onView(withId(R.id.productShortRating)).check(ViewAssertions.matches(ratingBarMatcher(5f)))
        composeTestRule.onRoot().performClick()

        assert(methodCallBackValue == templateQAProductShort)
    }

}