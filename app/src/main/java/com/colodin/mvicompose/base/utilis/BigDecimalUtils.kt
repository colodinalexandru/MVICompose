package com.colodin.mvicompose.base.utilis

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

fun BigDecimal.toCurrencyString(local: Locale): String {
    val numberFormat =  NumberFormat.getCurrencyInstance(local)
    numberFormat.currency = Currency.getInstance(local)
    numberFormat.maximumFractionDigits = 2
    numberFormat.minimumFractionDigits = 2

    return numberFormat.format(this)
}

fun BigDecimal.toStringWithLocal(local: Locale): String {
    val numberFormat = NumberFormat.getNumberInstance(local)
    numberFormat.maximumFractionDigits = 2
    numberFormat.minimumFractionDigits = 2
    return numberFormat.format(this)
}

fun BigDecimal.toStringWithPercent(local: Locale): String {
    val numberFormat = NumberFormat.getPercentInstance(local)
    numberFormat.maximumFractionDigits = 2
    numberFormat.minimumFractionDigits = 2
    return numberFormat.format(this.scaleByPowerOfTen(-2))
}