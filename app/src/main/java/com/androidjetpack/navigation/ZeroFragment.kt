package com.androidjetpack.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.androidjetpack.R
import kotlinx.android.synthetic.main.fragment_zero.*

/**
 * 作者：Nixon
 * date：2020/7/3.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class ZeroFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var mView: View = inflater.inflate(R.layout.fragment_zero, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val arg: ZeroFragmentArgs by navArgs()
//        tvZero.text = arg.toString()
    }
}