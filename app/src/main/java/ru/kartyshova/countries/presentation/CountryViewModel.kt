package ru.kartyshova.countries.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.kartyshova.countries.data.CountryResponse
import ru.kartyshova.countries.domain.GetAllCountriesUseCase

class CountryViewModel(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    private val _countryList = MutableLiveData<List<CountryResponse>>()
    val countryList: LiveData<List<CountryResponse>> = _countryList

    fun loadCountry() {
        viewModelScope.launch {
            val listResult = getAllCountriesUseCase()
            listResult.fold(
                onSuccess = {
                    _countryList.value = it
                },
                onFailure = {
                    Log.e("CountryViewModel", "Error while loading country list", it)
                }
            )
        }
    }
}

