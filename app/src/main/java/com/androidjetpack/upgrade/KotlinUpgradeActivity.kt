package com.androidjetpack.upgrade

import android.os.Bundle
import android.util.Log
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import okio.internal.commonAsUtf8ToByteArray

class KotlinUpgradeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_upgrade)

        anonymity()
        anonymity2()
    }

    private fun anonymity() {
        // 1、函数输入（也叫入参）输出的声明：methodeAction===>>函数的声明；
        //                              符号“:”后面的()===>>函数的输入，也叫入参；
        //                              符号“->”后面的String===>>函数的输出，也叫返回值；
        val methodeAction :  () -> String

        // 2、实现第一步声明的函数
        methodeAction = {
            // 我们可以在 匿名函数的具体实现里面，做各种操作
            val msg = "AndroidJetpack"
            // 匿名函数不要写 “return关键字”，因为默认最后一行就是返回值，加“return关键字”反而报错
            "${msg} ${this.javaClass.name}"
        }

        // 3、调用此函数，我们可以用函数的返回值做各种操作
        var value = methodeAction()
        log("KotlinUpgradeActivity", value)

        // 上面的函数，我们还可以进一步简化：
        // 1、函数输入（也叫入参）输出的声明：
        //     methodeAction===>>函数的声明；
        //     符号“:”后面的()===>>函数的输入，也叫入参；
        //     符号“->”后面的String===>>函数的输出，也叫返回值；
        //     符号“{”后面的params1, index===>>入参；
        //     params1参数对应前面的入参的String，index参数对应前面的入参的Int，他们按顺序与签名的入参类型一一对应
        val methodeActionSimply: (String, Int) -> String = { params1, index ->
            "${params1} === ${index * index}"
        }
        // 必须要有这一步，通过一个变量来接收函数的返回值，否则匿名函数的内部实现不会被执行。
        val valueSimply = methodeActionSimply("匿名函数", 999)
        log("KotlinUpgradeActivity", "valueSimply===== $valueSimply")
    }

    private fun anonymity2(){
        val testMethod : (Int) -> String = {it:Int ->
            val value = "$it, 这个位置的数据有异常哦"
            log("KotlinUpgradeActivity", value)
            val size = value.commonAsUtf8ToByteArray().size
            log("KotlinUpgradeActivity", size)
            value
        }

        // 一下两种调用方式 等价
        testMethod.invoke(3)
        testMethod(108)

        // 上面的实现还可以进一步简化成下面这样：
        val testMethod2 = { it:Int ->
            val value = "$it, 梁山108好汉，刚刚好"
            log("KotlinUpgradeActivity", value)
            value
        }
        // 上面，testMethod2后面的“{......}”就是匿名函数，他其实也是lambda表达式
        testMethod2(108)
    }
}