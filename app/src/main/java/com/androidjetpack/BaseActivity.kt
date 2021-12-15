package com.androidjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.androidjetpack.lifecycles.LifecycleObserverHandler
import com.androidjetpack.lifecycles.LifecycleObserverInter
import com.androidjetpack.log.Logs

/**
 * 作者：Nixon
 * date：2020/7/3.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
open class BaseActivity : AppCompatActivity(), LifecycleOwner, LifecycleObserverInter {
    val TAG = "TAGTAG"
    lateinit var mActivity: BaseActivity;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mActivity = this
        lifecycle.addObserver(LifecycleObserverHandler(this, this))
    }

    override fun onCreate(owner: LifecycleOwner) {
//        Logs.log("lifecycleOnCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
//        Logs.log("lifecycleOnStart")
    }

    override fun onResume(owner: LifecycleOwner) {
//        Logs.log("lifecycleOnResume")
    }

    override fun onPause(owner: LifecycleOwner) {
//        Logs.log("lifecycleOnPause")
    }

    override fun onStop(owner: LifecycleOwner) {
//        Logs.log("lifecycleOnStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
//        Logs.log("lifecycleOnDestroy")
    }

    fun log(tag:String = "TAGTAG", msg: Any) {
        System.out.println("${tag}============${msg}")
    }
}