package com.frodinm.ads_android_test.di

import com.frodinm.ads_android_test.usecases.ITimeCaptureUseCase
import com.frodinm.ads_android_test.usecases.impl.TimeCaptureUseCase
import org.koin.dsl.module

val usecaseModule  = module {
    single<ITimeCaptureUseCase> { TimeCaptureUseCase(get()) }
}
