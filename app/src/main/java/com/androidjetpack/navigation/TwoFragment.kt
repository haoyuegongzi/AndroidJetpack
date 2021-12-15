package com.androidjetpack.navigation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidjetpack.R

/**
 * 作者：Nixon
 * date：2020/7/3.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class TwoFragment :Fragment(){

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
        var mView:View = inflater.inflate(R.layout.fragment_two, container, false)
        return mView
    }
}