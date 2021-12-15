package com.androidjetpack.article

import android.app.ProgressDialog.show
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import kotlinx.coroutines.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class ArticleActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

    }

    fun runBlocking(mView: View) {
//        Log.e(TAG, "主线程id：${mainLooper.thread.id}" + "\n主线程name：" + Thread.currentThread().name)
//        test()
        launch()
//        threadReplace()
    }

    // 显式使用 runBlocking 协程构建器来阻塞
    fun test() {
        runBlocking {// 开始执行主协程
            GlobalScope.launch { // 在后台启动一个新的协程并继续
                delay(1000L)
                Log.e(TAG, "World!")
            }
            Log.e(TAG, "Hello,") // 主协程在这里会立即执行
            delay(1000L)      // 延迟 1 秒来保证 JVM 存活
            repeat(3) {
                Log.e(TAG, "协程执行$it 线程id：${Thread.currentThread().id}")
                delay(4500)
            }


            runBlocking { // this: CoroutineScope
                launch { // 在 runBlocking 作用域中启动一个新协程
                    delay(1000L)
                    Log.e(TAG, "World!")
                }
                Log.e(TAG, "Hello,")
            }
        }
    }
    // 这里的 runBlocking { …… } 作为用来启动顶层主协程的适配器。
    // 然后在方法体内部 使用任何喜欢的断言风格来使用挂起函数或者完成我们预定的业务

    fun launch() {
        Log.e(TAG, "主线程id：${mainLooper.thread.id}" + "\t主线程name：" + Thread.currentThread().name)
//        Log.e(TAG, "Hello,")
       GlobalScope.launch { // 启动一个新协程并保持对这个作业的引用
//            delay(1000L)
//            Log.e(TAG, "World!")
            suspendingPrint()
        }



//        job.join() // 等待直到子协程执行结束


//        GlobalScope.launch { // 在后台启动一个新的协程并继续
//            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
//            Log.e(TAG, "TAGTAG：World!") // 在延迟后打印输出
//            Log.e(TAG, "协程执行结束 -- 线程id：${Thread.currentThread().id}")
//        }
//        Log.e(TAG, "TAGTAG：Hello,") // 协程已在等待时主线程还在继续
//        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
//
////        job.start()//job有没有调用start方法都不影响delay()方法的执行。
//
//        Log.e(TAG, "协程执行结束")
    }

    suspend fun suspendingPrint() {        Log.e(TAG, "Thread: ${Thread.currentThread().name}")    }


    // GlobalScope.launch <==> thread
    // delay(long millis) <==> Thread.sleep(long millis)；但是delay(……)是非阻塞的，Thread.sleep(……)是阻塞的

    // 如果仅仅是将GlobalScope.launch 替换为 thread，编译器会报以下错误：
    // Error: Kotlin: Suspend functions are only allowed to be called from a coroutine or another suspend function
    // 这是因为 delay 是一个特殊的 挂起函数 ，它不会造成线程阻塞，但是会 挂起 协程，并且只能在协程中使用。
    fun threadReplace() {
        thread { // 在后台启动一个新的协程并继续
            Thread.sleep(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            Log.e(TAG, "TAGTAG：World!") // 在延迟后打印输出
            Log.e(TAG, "协程执行结束 -- 线程id：${Thread.currentThread().id}")
        }
        Log.e(TAG, "TAGTAG：Hello,") // 协程已在等待时主线程还在继续
        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
        Log.e(TAG, "协程执行结束")

//        //后台执行
//        GlobalScope.launch(Dispatchers.IO){
//            saveDataToDataBase(data)
//        }
//        前台执行
//        GlobalScope.launch(Dispatchers.Main){// 👈 在 UI 线程开始
//            val image = spendGetImage(imageId)
//            avatarIv.setImageBitmap(image)// 👈 执行结束后，自动切换回 UI 线程
//        }


//        GlobalScope.launch(Dispatchers.Main) {
//            //👇 async 函数启动新的协程
//            val avatar = async {
////                api.getAvatar(user)
//            }    // 获取用户头像
//            val logo = async {
////                api.getCompanyLogo(user)
//            } // 获取用户所在公司的 logo
//            //👇 获取返回值
//            show(this@ArticleActivity, avatar.await().toString(), logo.await().toString())// 更新 UI
//        }

//        // 主线程中
//        GlobalScope.launch(Dispatchers.Main) {
//            val image = suspendingGetImage(imageId)  // 获取图片
//            avatarIv.setImageBitmap(image)           // 显示出来
//
//            handler.post {
//                val image = suspendingGetImage(imageId)
//                avatarIv.setImageBitmap(image)
//            }
//        }
        GlobalScope.launch(Dispatchers.Main) {
            // 👇 耗时操作
//            val user = suspendingRequestUser()
//            updateView(user)
            withTimeout(1000L){

            }
            measureTimeMillis{

            }
        }

        GlobalScope.async() {

        }

    }
//    private suspend fun suspendingRequestUser() : User = withContext(Dispatchers.IO) {
//        api.requestUser()
//    }

//    suspend fun spendGetImage(imageId:String){
//        withContext(Dispatchers.IO){
//            getImage(imageId)
//        }
//    }

//    suspend fun suspendingGetImage(imageId: String) = withContext(Dispatchers.IO) {
//        getImage(imageId)
//    }

    var handler = Handler(object :Handler.Callback{
        override fun handleMessage(msg: Message): Boolean {
            //TODO：
            return false
        }
    })

}