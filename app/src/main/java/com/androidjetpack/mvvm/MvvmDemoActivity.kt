package com.androidjetpack.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.androidjetpack.R
import com.androidjetpack.databinding.ActivityMvvmDemoBinding
import com.androidjetpack.viewmodel.ModelBean
import org.jetbrains.anko.toast

class MvvmDemoActivity : AppCompatActivity() {

    var content = MutableLiveData<String>()
    var beanMut = MutableLiveData<ModelBean>()
    lateinit var binding:ActivityMvvmDemoBinding
    lateinit var viewModel: MVVMDemoViewModel
    var key = "MvvmDemo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding的初始化方式一
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_demo)
//        //binding的初始化方式二
//        binding = ActivityMvvmDemoBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.view = this


        viewModel = ViewModelProvider(this, ViewModelFactory(application)).get(MVVMDemoViewModel::class.java)

        lifecycle.addObserver(ViewModelObserver(viewModel))
        content.value = "J-16战斗机"

        viewModel.saveData(key, content.value.toString())
    }

    fun onSaveClick(view: View){
        toast("點擊保存按鈕，保存信息")
        viewModel.saveData(key, content.value + "、J-31战斗机、J-20战斗机")
        beanMut.value
    }

    fun onLoadClick(view:View){
        toast("點擊数据更新按鈕，讀取信息")
        viewModel.updateData(key, content)

    }
}