package com.androidjetpack.lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * 作者：Nixon
 * date：2020/7/8.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class LifecycleObserverHandler : LifecycleObserver {
    var mObserver: LifecycleObserverInter

    var TAG: String = "TAGTAG";
    var mLifecycleOwner: LifecycleOwner


    constructor(lifecycleOwner: LifecycleOwner, observer: LifecycleObserverInter) {
        mLifecycleOwner = lifecycleOwner;
        mObserver = observer;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mObserver.onCreate(mLifecycleOwner);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
//        Log.i(TAG, "onStart: ");
        mObserver.onStart(mLifecycleOwner);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
//        Log.i(TAG, "onResume: ");
        mObserver.onResume(mLifecycleOwner);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
//        Log.i(TAG, "onPause: ");
        mObserver.onPause(mLifecycleOwner);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
//        Log.i(TAG, "onStop: ");
        mObserver.onStop(mLifecycleOwner);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
//        Log.i(TAG, "onDestroy: ");
        mObserver.onDestroy(mLifecycleOwner);
    }
}