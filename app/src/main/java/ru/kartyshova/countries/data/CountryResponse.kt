package ru.kartyshova.countries.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryResponse(
    val name: String,
    val capital: String = "",
    val region: String,
    val timezones: List<String>,
    val flags: Flags,
    val currencies: List<Currencies> = emptyList()
):Parcelable

@Parcelize
data class Flags(
    val png: String
):Parcelable

@Parcelize
data class Currencies(
    val code: String,
    val name: String,
    val symbol: String
):Parcelable