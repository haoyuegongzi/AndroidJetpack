package com.androidjetpack.lifecycles

import androidx.lifecycle.LifecycleOwner

/**
 * 作者：Nixon
 * date：2020/7/8.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
interface LifecycleObserverInter {
    fun onCreate(owner: LifecycleOwner);
    fun onStart(owner: LifecycleOwner);
    fun onResume(owner: LifecycleOwner);
    fun onPause(owner: LifecycleOwner);
    fun onStop(owner: LifecycleOwner);
    fun onDestroy(owner: LifecycleOwner);
}