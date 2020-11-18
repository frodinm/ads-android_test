package com.frodinm.ads_android_test.repositories.impl

import com.frodinm.ads_android_test.repositories.ITimeCaptureLocal
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.*

class TimeCaptureLocal: ITimeCaptureLocal {

    private val timeObservable: BehaviorSubject<Date> = BehaviorSubject.createDefault(Date())


    override fun getTimeCaptureObservable(): Observable<Date> {
        return timeObservable.observeOn(Schedulers.io())
    }

    override fun triggerTimeCapture() {
        timeObservable.onNext(Date())
    }


}