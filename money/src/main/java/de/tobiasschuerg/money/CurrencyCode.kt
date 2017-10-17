package de.tobiasschuerg.money

import android.util.Log
import java.util.*


/**
 * Created by Tobias Schürg on 01.08.2017.
 */
data class CurrencyCode(val code: String) {

    fun getSymbol(): String {
        var symbol: String
        try {
            symbol = java.util.Currency.getInstance(code).symbol
        } catch (ia: IllegalArgumentException) {
            Log.w("Currency Code", "Could not find symbol for $code")
            symbol = code
        }
        return symbol
    }

    companion object {
        fun forDefaultLocale(): CurrencyCode {
            val currency = java.util.Currency.getInstance(Locale.getDefault())
            return CurrencyCode(currency.currencyCode)
        }
    }

}