package com.androidjetpack.mvvm

import android.app.Application
import com.androidjetpack.MmkvTools
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * 作者：Nixon
 * date：2020/7/30.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class NetWork(var mApplication: Application) {
    var app: Application = mApplication

    fun saveData(key:String, content: String): Observable<HttpResult<String>> {
        return Observable.create(object : ObservableOnSubscribe<HttpResult<String>> {
            override fun subscribe(e: ObservableEmitter<HttpResult<String>>) {
                var success = MmkvTools.getInstance().setString(key, content)
                var httpResult = HttpResult<String>()
                if (success) {
                    httpResult.status = 200;
                    httpResult.msg = "保存成功";
                } else {
                    httpResult.status = 5;
                    httpResult.msg = "保存失败";
                }
                httpResult.data = content;
                e.onNext(httpResult);
                e.onComplete();
            }
        }).delay(2L, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun updateData(key:String): Observable<HttpResult<String>> {
        return Observable.create(object : ObservableOnSubscribe<HttpResult<String>> {
            override fun subscribe(e: ObservableEmitter<HttpResult<String>>) {
                var success = MmkvTools.getInstance().getString(key)
                var httpResult = HttpResult<String>()

                httpResult.status = 200;
                httpResult.msg = "保存成功";
                httpResult.data = success;

                e.onNext(httpResult);
                e.onComplete();
            }

        }).delay(2L, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}