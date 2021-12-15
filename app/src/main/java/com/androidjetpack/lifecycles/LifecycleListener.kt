package com.androidjetpack.lifecycles

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.androidjetpack.log.Logs

/**
 * 作者：Nixon
 * date：2020/7/7.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class LifecycleListener : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun lifecycleOnCreate() {
        Logs.log("lifecycleOnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun lifecycleOnStart() {
        Logs.log("lifecycleOnStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun lifecycleOnResume() {
        Logs.log("lifecycleOnResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun lifecycleOnPause() {
        Logs.log("lifecycleOnPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun lifecycleOnStop() {
        Logs.log("lifecycleOnStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun lifecycleOnDestroy() {
        Logs.log("lifecycleOnDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun lifecycleOnAny() {
        Logs.log("lifecycleOnAny")
    }
}