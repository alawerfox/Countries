package ru.kartyshova.countries.data

import retrofit2.http.GET

interface CountryApi{

    @GET("v2/all")
    suspend fun getAll(): List<CountryResponse>

}