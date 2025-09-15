package com.colodin.mvicompose.base.utilies

import com.colodin.mvicompose.base.utilis.toCurrencyString
import com.colodin.mvicompose.base.utilis.toStringWithLocal
import com.colodin.mvicompose.base.utilis.toStringWithPercent
import org.junit.Test
import java.math.BigDecimal
import java.util.Locale
import kotlin.test.assertEquals

class BigDecimalUtilsTest {

    @Test
    fun toCurrencyString() {
        val result1 = BigDecimal.ONE.toCurrencyString(Locale.US)
        assertEquals("$1.00", result1)

        val result2 = BigDecimal(1234.8923452345234).toCurrencyString(Locale.US)
        assertEquals("$1,234.89", result2)
    }

    @Test
    fun toStringWithLocal() {
        val result1 = BigDecimal.ONE.toStringWithLocal(Locale.US)
        assertEquals("1.00", result1)

        val result2 = BigDecimal(1234.8923452345234).toStringWithLocal(Locale.US)
        assertEquals("1,234.89", result2)
    }

    @Test
    fun toStringWithPercent() {
        val result1 = BigDecimal.ONE.toStringWithPercent(Locale.US)
        assertEquals("1.00%", result1)

        val result2 = BigDecimal(1234.8923452345234).toStringWithPercent(Locale.US)
        assertEquals("1,234.89%", result2)
    }

}