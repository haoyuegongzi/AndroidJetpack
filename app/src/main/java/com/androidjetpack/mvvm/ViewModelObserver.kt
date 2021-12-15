package com.androidjetpack.mvvm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 作者：Nixon
 * date：2020/8/2.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class ViewModelObserver<T : BaseViewModel>(val mViewModel:T) :LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mViewModel.onCreate()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        mViewModel.onStart()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        mViewModel.onResume()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        mViewModel.onPause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        mViewModel.onStop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mViewModel.onDestroy()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun on(){
        mViewModel.onAny()
    }
}