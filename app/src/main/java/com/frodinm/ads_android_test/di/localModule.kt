package com.frodinm.ads_android_test.di

import com.frodinm.ads_android_test.repositories.ITimeCaptureLocal
import com.frodinm.ads_android_test.repositories.impl.TimeCaptureLocal
import org.koin.dsl.module

val localModule = module {
    single<ITimeCaptureLocal> { TimeCaptureLocal() }
}