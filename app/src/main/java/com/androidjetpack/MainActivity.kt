package com.androidjetpack

import android.content.Intent
import android.os.Bundle
import com.androidjetpack.article.ArticleActivity
import com.androidjetpack.databinding.DataBindingActivity
import com.androidjetpack.edittext.CustomEditTextActivity
import com.androidjetpack.hightOrder.HightOrderFunctionActivity
import com.androidjetpack.lifecycles.LifecyclesActivity
import com.androidjetpack.livedata.LiveDataActivity
import com.androidjetpack.mvvm.MvvmDemoActivity
import com.androidjetpack.navigation.NavigationPrimaryActivity
import com.androidjetpack.room.RoomSqlActivity
import com.androidjetpack.twowaybinding.TwoWayBindingActivity
import com.androidjetpack.upgrade.KotlinUpgradeActivity
import com.androidjetpack.viewmodel.ViewModelActivity
import com.androidjetpack.viewpager2.ViewPager2Activity
import com.androidjetpack.viewpager2.blank.BlankActivity
import com.androidjetpack.workmanager.WorkManagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MmkvTools.getInstance().initMmkv(application)

        StartUI()
    }

    fun StartUI(){
        tvViewPager2 .setOnClickListener {
            startActivity(Intent(mActivity, ViewPager2Activity::class.java))
        }
        tvViewPager2Frag.setOnClickListener {
            startActivity(Intent(mActivity, BlankActivity::class.java))
        }
        tvNavigationPrimary.setOnClickListener {
            startActivity(Intent(mActivity, NavigationPrimaryActivity::class.java))
        }
        tvDataBinding.setOnClickListener {
            startActivity(Intent(mActivity, DataBindingActivity::class.java))
        }
        tvRoomSQLit.setOnClickListener {
            startActivity(Intent(mActivity, RoomSqlActivity::class.java))
        }
        tvViewModel.setOnClickListener {
            startActivity(Intent(mActivity, ViewModelActivity::class.java))
        }
        tvLiveData.setOnClickListener {
            startActivity(Intent(mActivity, LiveDataActivity::class.java))
        }
        tvLifecycles.setOnClickListener {
            startActivity(Intent(mActivity, LifecyclesActivity::class.java))
        }
        tvTwoWayBinding.setOnClickListener {
            startActivity(Intent(mActivity, TwoWayBindingActivity::class.java))
        }
        tvMvvmDemo.setOnClickListener {
            startActivity(Intent(mActivity, MvvmDemoActivity::class.java))
        }
        tvArticle.setOnClickListener {
            startActivity(Intent(mActivity, ArticleActivity::class.java))
        }
        tvCustomEditText.setOnClickListener {
            startActivity(Intent(mActivity, CustomEditTextActivity::class.java))
        }
        tvWorkManager.setOnClickListener {
            startActivity(Intent(mActivity, WorkManagerActivity::class.java))
        }
        tvHightOrder.setOnClickListener {
            startActivity(Intent(mActivity, HightOrderFunctionActivity::class.java))
        }
        tvHightOrder.setOnClickListener {
            startActivity(Intent(mActivity, KotlinUpgradeActivity::class.java))
        }


    }
}