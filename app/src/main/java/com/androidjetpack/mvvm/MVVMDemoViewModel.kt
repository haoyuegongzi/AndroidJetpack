package com.androidjetpack.mvvm

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidjetpack.log.Logs
import io.reactivex.functions.Consumer

/**
 * 作者：Nixon
 * date：2020/7/30.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class MVVMDemoViewModel(app: Application) : ViewModel(), BaseViewModel {
    var repository: MVVMDemoRepository = MVVMDemoRepository(app)

    fun saveData(key: String, content: String) {
        repository.saveData(key, content, "")
    }

    fun getData(key: String): String {
        return repository.getData(key)
    }

    @SuppressLint("CheckResult")
    fun updateData(key: String, content: MutableLiveData<String>) {
        repository.updateData(key).subscribe(object : Consumer<String> {
            override fun accept(t: String) {
                content.value = t
            }
        })
    }

    override fun onCreate() {
        Logs.log("onCreate")
    }

    override fun onStart() {
        Logs.log("onStart")
    }

    override fun onResume() {
        Logs.log("onResume")
    }

    override fun onPause() {
        Logs.log("onPause")
    }

    override fun onStop() {
        Logs.log("onStop")
    }

    override fun onDestroy() {
        Logs.log("onDestroy")
    }

    override fun onAny() {
        Logs.log("onAny")
    }
}

