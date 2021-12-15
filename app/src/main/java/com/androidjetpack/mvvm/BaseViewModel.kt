package com.androidjetpack.mvvm


/**
 * 作者：Nixon
 * date：2020/8/2.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
interface BaseViewModel {
    fun onCreate()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()

    fun onAny()
}