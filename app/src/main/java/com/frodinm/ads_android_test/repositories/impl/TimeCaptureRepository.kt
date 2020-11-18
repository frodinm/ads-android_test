package com.frodinm.ads_android_test.repositories.impl

import com.frodinm.ads_android_test.repositories.ITimeCaptureLocal
import com.frodinm.ads_android_test.repositories.ITimeCaptureRepository
import io.reactivex.rxjava3.core.Observable
import java.util.*

class TimeCaptureRepository(private val local: ITimeCaptureLocal): ITimeCaptureRepository {
    override fun getTimeCaptureObservable(): Observable<Date> {
        return local.getTimeCaptureObservable()
    }

    override fun triggerTimeCapture() {
        local.triggerTimeCapture()
    }
}