package com.androidjetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.androidjetpack.http.ApiClient
import com.androidjetpack.http.HomeArticleList
import com.androidjetpack.http.Logging
import com.haoyue.wanandroidkotlin.http.HttpClient

/**
 * 作者：Nixon
 * date：2020/7/6.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class ViewModelAct : ViewModel() {
    var mCount = 0

    fun setData(): ModelBean {
        mCount = (++mCount) % 4
        return when (mCount) {
            0 -> ModelBean("Stella还在读小学", "PrimarySchool", mCount.toString())
            1 -> ModelBean("YuYu还在读初中", "MiddleSchool", mCount.toString())
            2 -> ModelBean("斯黛拉还在读高中", "HighSchool", mCount.toString())
            else -> ModelBean("zhong开始读大学", "UniversitySchool", mCount.toString())
        }
    }

    fun requestData(callBack: HttpClient.HttpCallBack<HomeArticleList>) {
        HttpClient.requestData(
            HttpClient.getService(ApiClient.HomePageAPI::class.java).homeArticleList(0.toString()),
            object : HttpClient.HttpCallBack<HomeArticleList> {
                override fun success(v: HomeArticleList) {
                    if (v.errorCode != 0) {
                        failed(Throwable())
                        return
                    }
                    //TODO：UPDATE UI
                    var article: HomeArticleList = v

                    Logging.log("数据请求成功啦：$v.toString()，，${v.data.datas[0]}")
                    callBack.success(v)
                }

                override fun failed(t: Throwable) {
                    Logging.log("请求失败：${t.toString()}")
                }
            })
    }
}