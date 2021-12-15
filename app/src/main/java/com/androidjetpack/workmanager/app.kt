//package com.mobile.automatic
//
//import android.app.Application
//import android.os.Build
//import android.util.Log
//import android.os.Environment
//import androidx.work.*
//import com.mobile.automatic.ui.room.SmsDatabase
//import com.aliyun.sls.android.producer.*
//import com.mobile.automatic.base.MyCrashHandler
//import com.mobile.automatic.common.*
//import com.mobile.automatic.utils.MmkvTools
//import com.mobile.automatic.work.ReportMessageWorker
//import com.mobile.automatic.work.ShoeWorker
//import com.uuzuche.lib_zxing.activity.ZXingLibrary
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import java.util.concurrent.TimeUnit
//
///**
// *
// * @author: Nixon
// * @ProjectName: SmsAssistant
// * @Package: com.mobile.automatic.base
// * @ClassName: App
// * @CreateDate: 2020/10/28 13:48
// * @Description: 本类作用描述：
// * @UpdateUser: 更新者：
// * @UpdateRemark: 更新说明：
// */
//class App : Application() {
//    companion object App {
//        lateinit var app: Application
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        app = this
//
//        MmkvTools.getInstance().initMmkv(this)
//        ZXingLibrary.initDisplayOpinion(this)
//
//        delayedInit()
//    }
//
//
//    private fun delayedInit() {
//        CoroutineScope(Dispatchers.Default).launch {
//            setupRecurringWork()
//        }
//    }
//
//    private fun setupRecurringWork() {
//        val constraints = Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.CONNECTED)
//            .setRequiresCharging(true)
//            .setRequiresCharging(true)
//            .setRequiresBatteryNotLow(true)
//            .apply {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    setRequiresDeviceIdle(true)
//                }
//            }
//            .build()
//        var findAll = SmsDatabase.getInstance(this).dao().findAll()
//        findAll.forEach {
//            Log.e("Assistant", "setupRecurringWork============: ${it.text}  ===${it.time}",)
//        }
//        var name = Thread.currentThread().getName()
//        Log.e("TAG", "onCreate: $name", )
//        val request = OneTimeWorkRequestBuilder<ShoeWorker>().build()
//        WorkManager.getInstance(this).enqueue(request)
//        val repeatingRequest = PeriodicWorkRequestBuilder<ReportMessageWorker>(15, TimeUnit.MINUTES)
//            .setConstraints(constraints)
//            .build()
//        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
//            ReportMessageWorker.WORK_NAME,
//            ExistingPeriodicWorkPolicy.REPLACE,
//            repeatingRequest
//        )
//    }
//}
