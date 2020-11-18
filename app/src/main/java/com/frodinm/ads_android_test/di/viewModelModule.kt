package com.frodinm.ads_android_test.di

import com.frodinm.ads_android_test.ui.capture.TimeCaptureViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TimeCaptureViewModel(get()) }
}