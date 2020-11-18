package com.frodinm.ads_android_test

import android.app.Application
import android.os.StrictMode
import com.frodinm.ads_android_test.di.localModule
import com.frodinm.ads_android_test.di.repositoryModule
import com.frodinm.ads_android_test.di.usecaseModule
import com.frodinm.ads_android_test.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setStrictModeOn()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            androidFileProperties()

            modules(listOf(
                localModule,
                repositoryModule,
                usecaseModule,
                viewModelModule
            ))
        }
    }

    private fun setStrictModeOn() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .build())
    }
}