package com.frodinm.ads_android_test.usecases.impl

import com.frodinm.ads_android_test.repositories.ITimeCaptureRepository
import com.frodinm.ads_android_test.usecases.ITimeCaptureUseCase
import io.reactivex.rxjava3.core.Observable
import java.util.*

class TimeCaptureUseCase(private val repository: ITimeCaptureRepository): ITimeCaptureUseCase {
    override fun getObservable(): Observable<Date> {
        return repository.getTimeCaptureObservable()
    }

    override fun triggerEvent() {
       repository.triggerTimeCapture()
    }
}