package com.androidjetpack.mvvm

import android.annotation.SuppressLint
import android.app.Application
import com.androidjetpack.MmkvTools
import io.reactivex.Observable
import io.reactivex.functions.Function


/**
 * 作者：Nixon
 * date：2020/7/30.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class MVVMDemoRepository {
    var mNetWork:NetWork

    constructor(app:Application){
        mNetWork = NetWork(app)
    }

    @SuppressLint("CheckResult")
    fun saveData(key: String, value: String) {
        MmkvTools.getInstance().setString(key, value)
    }

    fun getData(key: String): String {
        return MmkvTools.getInstance().getString(key, "")
    }

    fun saveData(key:String, content:String, value: String): Observable<String> {
        return mNetWork.saveData(key, content).map(object : Function<HttpResult<String>, String>{
            override fun apply(t: HttpResult<String>): String {
                return t.data + ""
            }
        })
    }

    fun updateData(key:String): Observable<String> {
        return mNetWork.updateData(key ).map(object : Function<HttpResult<String>, String>{
            override fun apply(t: HttpResult<String>): String {
                return t.data + ""
            }
        })
    }
}