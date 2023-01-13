package ru.kartyshova.countries

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.kartyshova.countries.di.dependency

class CountryApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CountryApplication)
            modules(dependency)
        }
    }
}