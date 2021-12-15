package com.androidjetpack.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 作者：Nixon
 * date：2020/7/30.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class MVVMDemoFactory(val viewModel: MVVMDemoViewModel): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModel as T
    }
}