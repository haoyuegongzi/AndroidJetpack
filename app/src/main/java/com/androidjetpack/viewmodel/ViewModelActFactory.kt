package com.androidjetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 作者：Nixon
 * date：2020/7/6.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class ViewModelActFactory(var count: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return ViewModelAct() as T
        return modelClass as T
    }
}