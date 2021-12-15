package com.androidjetpack.http

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 作者：Created by chen1 on 2020/5/1.
 * 邮箱：chen126jie@163.com
 * TODO：
 */
class ApiClient {
    interface HomePageAPI{
        @GET("article/list/{id}/json")
        fun homeArticleList(@Path("id") id :String): Observable<HomeArticleList>
    }
}