package com.androidjetpack.databinding

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import kotlinx.android.synthetic.main.activity_live_data.*

class DataBindingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_live_data)

        val binding: ActivityLiveDataBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_live_data
        )

        binding.mStudent = Student("陈程", "9年级", "15")

        tvButton.setOnClickListener {
            when((System.currentTimeMillis() % 2)){
                0L->binding.sudentInfo = Student("陈程", "12年级", (System.currentTimeMillis() % 50).toString())
                1L -> binding.sudentInfo = Student("晓晓", "20年级", (System.currentTimeMillis() % 50).toString())
            }
            binding.mStudent = binding.sudentInfo
        }
    }

    fun ageClick(mView:View){
        println("试试这样的写法？？？？？？？？？？？？？？？？？？？？")



    }
}