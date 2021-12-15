package com.androidjetpack.livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 作者：Nixon
 * date：2020/7/7.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class ViewModelLiveDataFactory(var mKey:String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelLiveData() as T
    }
}