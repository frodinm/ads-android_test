package com.frodinm.ads_android_test.usecases

import io.reactivex.rxjava3.core.Observable
import java.util.*

interface ITimeCaptureUseCase {
    fun getObservable(): Observable<Date>
    fun triggerEvent()
}