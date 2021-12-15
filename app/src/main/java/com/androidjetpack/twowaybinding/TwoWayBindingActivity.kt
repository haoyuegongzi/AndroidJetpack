package com.androidjetpack.twowaybinding

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.androidjetpack.BR
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import com.androidjetpack.databinding.ActivityTwoWayBindingBinding
import kotlinx.android.synthetic.main.activity_two_way_binding.*

class TwoWayBindingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //经过绑定之后，binding实质上可以理解为是xml布局文件的代理对象。
        //初始化binding有两种方式：一是DataBindingUtil.setContentView();二是****Binding.inflate()、setContentView(binding.root);
        //在Activity里面的实现：****Binding.inflate(layoutInflater); setContentView(binding.root);
        //在Fragment里面的实现：****Binding.inflate(inflater, container, false); return mBinding.root;

        var binding: ActivityTwoWayBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding)

//        var binding: ActivityTwoWayBindingBinding = ActivityTwoWayBindingBinding.inflate(layoutInflater);
        setContentView(binding.root)

        var auth = ObservableField<String>("auth")
        binding.auth = auth

        binding.authInfo = AuthInfo("任缥缈", "缥缈剑法")

        //经过DataBindingUtil绑定之后，下面的这两种获取Button按钮的方式是等效的。
        btnBinding.setOnClickListener {
            //TODO：
        }
        binding.btnBinding.setOnClickListener {
            binding.authInfo = AuthInfo("Stella", "HR")
            auth.set("少操没用的心，多操喜欢的人")
        }


        // ViewModel初始化(在Activity和Fragment里面的初始化是一样的)
        // ***ViewModel mViewModel = ViewModelProvider(this).get(***ViewModel::class.java)
        // Fragment里面还可以使用：ViewModelProvider(getActivity()).get(***ViewModel::class.java)
        // 这里需要说明的是:Fragment里面使用的ViewModelProvider(getActivity()).get***,
        // 也可以使用ViewModelProvider(this),如果使用getActivity()则在Activity中的Fragment与Activity使用相同的ViewModel。


    }
}