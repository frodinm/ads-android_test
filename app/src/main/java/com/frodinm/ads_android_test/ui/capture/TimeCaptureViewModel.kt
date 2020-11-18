package com.frodinm.ads_android_test.ui.capture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frodinm.ads_android_test.ui.Event
import com.frodinm.ads_android_test.usecases.ITimeCaptureUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.TimeUnit

class TimeCaptureViewModel(private val usecase: ITimeCaptureUseCase): ViewModel() {

    val timeStamp1 = MutableLiveData("")
    val timeStamp2 = MutableLiveData("")
    val timeStamp3 = MutableLiveData("")
    val timeStamp4 = MutableLiveData("")

    private val _refreshedTimeStampsEvent = MutableLiveData<Event<Any>>()
    val refreshedTimeStampsEvent: LiveData<Event<Any>>
        get() = _refreshedTimeStampsEvent

    init {
        usecase.getObservable().subscribeOn(AndroidSchedulers.mainThread()).map {
            timeStamp1.postValue(Date().time.toString())
        }.delay((Math.random() * 1000).toLong(), TimeUnit.MILLISECONDS).map {
            timeStamp2.postValue(Date().time.toString())
        }.delay((Math.random() * 1000).toLong(), TimeUnit.MILLISECONDS).map {
            timeStamp3.postValue(Date().time.toString())
        }.delay((Math.random() * 1000).toLong(), TimeUnit.MILLISECONDS).map {
            timeStamp4.postValue(Date().time.toString())
        }.subscribe()
    }


    fun handleFabClick() {
        usecase.triggerEvent()
    }
}