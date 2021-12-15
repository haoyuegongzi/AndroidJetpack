package com.androidjetpack.log;

import android.util.Log;

/**
 * 作者：Created by chen1 on 2020/3/16.
 * 邮箱：chen126jie@163.com
 * TODO：
 */
public class Logs {

    static String TAG = "TAGTAG";
    public static void log(String s){
        Log.e(TAG, "log----->>>" + s);
    }
}
