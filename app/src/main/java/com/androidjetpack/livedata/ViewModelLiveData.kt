package com.androidjetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 作者：Nixon
 * date：2020/7/6.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class ViewModelLiveData:ViewModel() {

    var mNameEvent: MutableLiveData<String> = MutableLiveData()

    fun getNameEvent(): MutableLiveData<String> {
        return mNameEvent
    }
}