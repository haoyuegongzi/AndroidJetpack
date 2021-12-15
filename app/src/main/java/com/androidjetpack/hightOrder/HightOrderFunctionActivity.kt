package com.androidjetpack.hightOrder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.androidjetpack.R

class HightOrderFunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hight_order_function)
    }




    fun b(input:String):String{
        return input.reversed()
    }
}