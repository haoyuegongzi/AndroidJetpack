package com.androidjetpack.article

/**
 * 作者：Nixon
 * date：2020/8/4.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
interface Customer<in T> {
    fun customer(customer: T)
}