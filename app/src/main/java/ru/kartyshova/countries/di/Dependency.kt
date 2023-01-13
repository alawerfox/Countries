package ru.kartyshova.countries.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import ru.kartyshova.countries.data.CountryApi
import ru.kartyshova.countries.data.CountryRepository
import ru.kartyshova.countries.domain.GetAllCountriesUseCase
import ru.kartyshova.countries.presentation.CountryViewModel

private const val BASE_URL = "https://restcountries.com/"

val dependency = module {
    single<CountryApi> {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

        return@single retrofit.create(CountryApi::class.java)
    }

    single { CountryRepository(get()) }

    single { GetAllCountriesUseCase(get()) }

    viewModel { CountryViewModel(get()) }

}