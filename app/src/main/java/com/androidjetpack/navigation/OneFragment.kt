package com.androidjetpack.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.androidjetpack.R
import com.androidjetpack.viewmodel.ViewModelAct
import kotlinx.android.synthetic.main.fragment_one.*

/**
 * 作者：Nixon
 * date：2020/7/3.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class OneFragment :Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var mView:View = inflater.inflate(R.layout.fragment_one, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewModel: ViewModelAct? = activity?.let {
            ViewModelProvider(it).get(ViewModelAct::class.java)
        }
    }
}