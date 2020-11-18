package com.frodinm.ads_android_test.di

import com.frodinm.ads_android_test.repositories.ITimeCaptureRepository
import com.frodinm.ads_android_test.repositories.impl.TimeCaptureRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ITimeCaptureRepository> { TimeCaptureRepository(get()) }
}