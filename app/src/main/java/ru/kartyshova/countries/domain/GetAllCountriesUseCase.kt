package ru.kartyshova.countries.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kartyshova.countries.data.CountryRepository
import ru.kartyshova.countries.data.CountryResponse

class GetAllCountriesUseCase (private val countryRepository: CountryRepository){
    suspend operator fun invoke(): Result<List<CountryResponse>> = withContext(Dispatchers.IO){
        return@withContext runCatching {
            countryRepository.getAll()
        }
    }
}