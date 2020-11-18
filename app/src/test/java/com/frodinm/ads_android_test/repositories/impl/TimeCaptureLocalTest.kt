package com.frodinm.ads_android_test.repositories.impl

import com.frodinm.ads_android_test.repositories.ITimeCaptureLocal
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.subjects.BehaviorSubject
import org.junit.Test
import java.util.*

class TimeCaptureLocalTest {

    private val timeCaptureLocal = mock<ITimeCaptureLocal>()

    @Test
    fun testGetObservable() {
        // PREPARE

        whenever(timeCaptureLocal.getTimeCaptureObservable()).thenReturn(BehaviorSubject.createDefault(Date()))

        //PERFORM

        val result = timeCaptureLocal.getTimeCaptureObservable().test()

        //CHECK
        result.assertNoErrors()
    }
}