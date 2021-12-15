package com.androidjetpack.lifecycles

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import com.androidjetpack.log.Logs

class LifecyclesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycles)
        Logs.log("onCreate")
    }
}

