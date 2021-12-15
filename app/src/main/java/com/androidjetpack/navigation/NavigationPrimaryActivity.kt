package com.androidjetpack.navigation

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import com.androidjetpack.log.LogUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.jetbrains.anko.toast

class NavigationPrimaryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_primary)
        //第一步获取到NavHostFragment,这里的nav_fragment就是本Activity对应的xml里面Fragment标签的id。
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment? ?: return
        //第二步获取到NavController，这一步的内容几乎都是死的。
        val navController = host.navController
        //第三步配置BottomNavigationView，这里的bottom_nav_view就是本Activity对应的xml里面BottomNavigationView控件的id。
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        //这里，将导航控件BottomNavigationView与navController关联起来。
        bottomNav?.setupWithNavController(navController)
        //第四步添加路由监听，这一步的内容几乎都是死的。
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                destination.id.toString()
            }
            toast("Navigated to $dest")
            printLoginfo("Navigated to $dest")
        }
    }

    fun printLoginfo(msg:String){
        LogUtil.logs(msg)
    }
}