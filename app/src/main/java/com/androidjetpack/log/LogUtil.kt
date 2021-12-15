package com.androidjetpack.log

import com.stormkid.okhttpkt.utils.Log

/**
 * 作者：Nixon
 * date：2020/7/3.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class LogUtil {
    companion object{
        fun logs(msg:String){
            Log.e("TAGTAG", msg)
        }
    }
}