package com.androidjetpack.mvvm


/**
 * 作者：Nixon
 * date：2020/7/30.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class HttpResult<T> {
    var status = 0
    var msg: String? = null
    var data: T? = null
}