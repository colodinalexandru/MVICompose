package com.colodin.mvicompose.product.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.colodin.mvicompose.R
import com.colodin.mvicompose.product.data.QAProductShort
import org.junit.Rule
import org.junit.Test

class ProductListTest {

    @get:Rule(order = 0)
    val composeTestRule = createComposeRule()


    private val templateQAProductShort by lazy {
        QAProductShort(id = 1, title = "Product title", price = "$1", rating = 5f, thumbnail = "")
    }

    @Test
    fun test_product_list_empty() {

        composeTestRule.setContent {
            ProductList(emptyList()) {

            }
        }
        composeTestRule.onRoot().assertIsNotDisplayed()
    }

    // In fact, you don't need this test
    @Test
    fun test_product_list_one_item() {

        var methodCallBackValue:QAProductShort? = null
        composeTestRule.setContent {
            ProductList(listOf(templateQAProductShort)) {
                methodCallBackValue = it
            }
        }

        composeTestRule.onNodeWithText("Product title").assertIsDisplayed()
        composeTestRule.onNodeWithText("$1").assertIsDisplayed()
        Espresso.onView(ViewMatchers.withId(R.id.productShortRating)).check(ViewAssertions.matches(ratingBarMatcher(5f)))
        composeTestRule.onNodeWithText("Product title").performClick()
        composeTestRule.waitForIdle()
        assert(methodCallBackValue == templateQAProductShort)
    }


    // In fact, you don't need this test
    @Test
    fun test_product_list_more_items() {

        var methodCallBackValue:QAProductShort? = null
        val firstItem = templateQAProductShort
        val secondItem = templateQAProductShort.copy(id = 2, title = "test", price = "$2", rating = 5f, thumbnail = "")
        composeTestRule.setContent {
            ProductList(listOf(firstItem,secondItem)) {
                methodCallBackValue = it
            }
        }

        composeTestRule.onNodeWithText("Product title").assertIsDisplayed()
        composeTestRule.onNodeWithText("$1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Product title").performClick()
        composeTestRule.waitForIdle()
        assert(methodCallBackValue == firstItem)

        composeTestRule.onNodeWithText("test").assertIsDisplayed()
        composeTestRule.onNodeWithText("$2").assertIsDisplayed()
        composeTestRule.onNodeWithText("test").performClick()
        composeTestRule.waitForIdle()
        assert(methodCallBackValue == secondItem)
    }

}
