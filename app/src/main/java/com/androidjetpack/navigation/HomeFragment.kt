package com.androidjetpack.navigation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.androidjetpack.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 作者：Nixon
 * date：2020/7/3.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class HomeFragment :Fragment(){
    var mActivity:NavigationPrimaryActivity? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = (context as NavigationPrimaryActivity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var mView:View = inflater.inflate(R.layout.fragment_home, container, false)
        return mView
    }

    //在onCreateView()方法和onStart()方法里面直接通过id操作控件的话，会要求必须加findViewById()获取控件id，
    //否则就会报"must not be null"这个错误。
    //但是在onViewCreated()方法里面就不用这样。另外自定义的方法里面也是必须获取控件id。
    //可以这么理解：在Fragment里面，除了在onViewCreated()方法里面直接操作控件或者调用操作控件的方法外，
    //其他任何地方操作控件或者调用操作控件的方法都是需要通过findViewById()获取控件id，否者就会报上面的错误。
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        operationView()
        //其中，id值action_homeFragment_to_oneFragment是我们在nav_host.xml资源内添加的action属性。
        //这里是定义了一个无参跳转:homeFragment_to_oneFragment
        open1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_oneFragment))
    }

    fun operationView() {
        tvTitle.text = "皇者号天令"
    }
}