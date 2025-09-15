package com.colodin.mvicompose.product.presentation

import android.view.View
import android.widget.RatingBar
import androidx.core.view.isVisible
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher



fun ratingBarMatcher(rating: Float): Matcher<View?> {
    return object : BoundedMatcher<View?, RatingBar>(RatingBar::class.java) {
        override fun describeTo(description: Description?) {
            description?.appendText("RatingBar doesn't have the correct value :$rating or is invisible")
        }

        override fun matchesSafely(item: RatingBar): Boolean {
            return item.rating == rating && item.isVisible
        }

    }
}