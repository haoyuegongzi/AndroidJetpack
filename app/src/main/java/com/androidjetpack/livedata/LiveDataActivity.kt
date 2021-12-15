package com.androidjetpack.livedata

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import kotlinx.android.synthetic.main.activity_live_data2.*


class LiveDataActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data2)

//        var mViewModel = ViewModelProvider(this).get(ViewModelLiveData::class.java)
//        var nameEvent = mViewModel.getNameEvent()
//        nameEvent.observe(this, Observer<String> {
//            println("接收到的值it====$it")
//            tvObserver.text = it
//        })
//
//        tvTitle.setOnClickListener {
//            var random = System.currentTimeMillis()
//            mViewModel.getNameEvent().value = "Stella $random"
//        }

/*******************************************************************************************************/
        // Activity 中
        var mkey = "mkey"
        var mViewModelAct = ViewModelProvider(this, ViewModelLiveDataFactory(mkey)).get(ViewModelLiveData::class.java)
//        mViewModelAct.
        val nameEventAct = mViewModelAct.getNameEvent()
        nameEventAct.observe(this, Observer<String> { s ->
            println("接收到的值it====$s")
            tvObserver.text = s
        })

        tvTitle.setOnClickListener {
            mViewModelAct.getNameEvent().value = "Stella ${System.currentTimeMillis()}"
        }

        mViewModelAct.getNameEvent().value = "默认状态下先来一波自定义的数据？"
        /*******************************************************************************************************/
//        // Fragment 中
        var mActivity = this;
        var mViewModel = ViewModelProvider(
            mActivity,
            ViewModelLiveDataFactory(mkey)
        ).get(ViewModelLiveData::class.java)
        mViewModel.getNameEvent().observe(this, Observer<String> {
            println("接收到的值it====$it")
            tvObserver.text = it
            var result: Boolean = (mViewModel === mViewModelAct)
        })
//
//        tvTitle.setOnClickListener {
//            var random = System.currentTimeMillis()
//            mViewModelAct.getNameEvent().value = "Stella $random"
//        }





    }

}