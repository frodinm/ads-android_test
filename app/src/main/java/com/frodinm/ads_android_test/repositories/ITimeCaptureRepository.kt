package com.frodinm.ads_android_test.repositories

import io.reactivex.rxjava3.core.Observable
import java.util.*

interface ITimeCaptureRepository {
    fun getTimeCaptureObservable(): Observable<Date>
    fun triggerTimeCapture()
}