package ru.kartyshova.countries.data

class CountryRepository(private val countryApi: CountryApi) {
    suspend fun getAll(): List<CountryResponse> {
        return countryApi.getAll()
    }

}