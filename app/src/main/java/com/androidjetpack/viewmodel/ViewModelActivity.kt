package com.androidjetpack.viewmodel

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import com.androidjetpack.databinding.ActivityViewModelBinding
import com.androidjetpack.http.HomeArticleList
import com.haoyue.wanandroidkotlin.http.HttpClient
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : BaseActivity() {
    lateinit var viewModel: ViewModelAct
    lateinit var binding: ActivityViewModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)

        viewModel = ViewModelProvider(this).get(ViewModelAct::class.java)

//        binding.vMpdel = viewModel.setData()

        btnViewModel.setOnClickListener {
//            binding.vMpdel = viewModel.setData()

            viewModel.requestData(object : HttpClient.HttpCallBack<HomeArticleList> {
                override fun success(v: HomeArticleList) {
                    //TODO：UPDATE UI
                    binding.wanandroid = v
                }

                override fun failed(t: Throwable) {
                    //TODO：抛出异常
                }
            })
        }
    }
}