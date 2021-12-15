package com.androidjetpack.mvvm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 作者：Nixon
 * date：2020/8/2.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class ViewModelFactory(var app:Application):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MVVMDemoViewModel(app) as T
    }
}