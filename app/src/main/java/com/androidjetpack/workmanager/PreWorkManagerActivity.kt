package com.androidjetpack.workmanager

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.work.*
import com.androidjetpack.R
import com.androidjetpack.log.Logs
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
 * 备份
 */
public class PreWorkManagerActivity : AppCompatActivity() {
    val tag = "SMS"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

            init()

//        //按tag标签来观察任务状态
//        val workInfoTag: ListenableFuture<List<WorkInfo>> = WorkManager.getInstance(this).getWorkInfosByTag(tag)
//        //按任务的id标签来观察任务状态
//        val workInfoId: ListenableFuture<WorkInfo> = WorkManager.getInstance(this).getWorkInfoById(oneWorkReq.id)
//        //通过给任务指定的唯一名来观察任务状态
//        val name = "uniqueWorkName"
//        val workInfoUn: ListenableFuture<List<WorkInfo>> = WorkManager.getInstance(this).getWorkInfosForUniqueWork(name)

        //按tag标签来观察任务状态
//        val workInfoByTag:LiveData<List<WorkInfo>> = WorkManager.getInstance(this).getWorkInfosByTagLiveData(tag)
//        //按任务的id标签来观察任务状态
//        val workId:LiveData<WorkInfo> = WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneWorkReq.id)
//        val workByUn:LiveData<List<WorkInfo>> = WorkManager.getInstance(this).getWorkInfosForUniqueWorkLiveData(name)

        //通过tag标签
        WorkManager.getInstance(this).getWorkInfosByTagLiveData(tag).observe(this, {
            it.forEach {
                Logs.log("通过tag标签观察到的：workInfo:" + it)
            }
        })
        //通过id
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneWorkReq.id).observe(this, {
            if (it != null && it.getState() === WorkInfo.State.SUCCEEDED) {
                val outputData: String? = it.outputData.getString("output_data")
                Logs.log("通过id观察到的：workInfo:" + outputData)
            }
        })
    }

    lateinit var mConstraints:Constraints
    lateinit var oneWorkReq: OneTimeWorkRequest
//    lateinit var oneWorkReq2: OneTimeWorkRequest
//    lateinit var periodicWork:PeriodicWorkRequest

    @SuppressLint("IdleBatteryChargingConstraints", "RestrictedApi")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun init() {
        mConstraints = Constraints.Builder()
//            .setRequiresDeviceIdle(true)                  //要求设备处于空闲状态
//            .setRequiresCharging(true)                    //要求设备正在充电
//            .setRequiresBatteryNotLow(true)               //要求设备未处于低电量状态
//            .setRequiresStorageNotLow(true)               //要求设备未处于低内存状态
//            .setRequiredNetworkType(NetworkType.METERED)  //要求设备网络环境
            .build()

        val inputData: Data = Data.Builder()
            .putString("input_data", "Hello World")
            .put("ICON", R.mipmap.wjx).build()
        oneWorkReq = OneTimeWorkRequest.Builder(CustomWoker::class.java)
            .setConstraints(mConstraints)
            .setInitialDelay(3, TimeUnit.SECONDS)
            //设置指数退避算法
//            .setBackoffCriteria(BackoffPolicy.LINEAR, OneTimeWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)
            .addTag(tag)
            .setInputData(inputData)
            .build()
        WorkManager.getInstance(this).enqueue(oneWorkReq)

//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneWorkReq.id)
//            .observe(this, {
//                Logs.log(it.toString())
//            })


//        //WorkManager.getWorkInfosByTagLiveData(String tag)或者取消任务WorkManager.cancelAllWorkByTag(String tag)。
//        periodicWork = PeriodicWorkRequest
//            .Builder(CustomWoker::class.java, 15, TimeUnit.MINUTES)
//            .addTag(tag)
//            .setConstraints(mConstraints)
//            .setBackoffCriteria(
//                BackoffPolicy.LINEAR,
//                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
//                TimeUnit.MILLISECONDS
//            )
//            .setInputData(inputData)
//            .build()
//        WorkManager.getInstance(this).enqueue(periodicWork)
//        WorkManager.getInstance(this).getWorkInfosByTagLiveData("").observe(this, {
//            it.forEach {
//                Logs.log(it.toString())
//            }
//        })
//
//        oneWorkReq2 = OneTimeWorkRequest.Builder(CustomWoker::class.java)
//            .setConstraints(mConstraints)
//            .setInitialDelay(10, TimeUnit.SECONDS)
//            //设置指数退避算法
//            .setBackoffCriteria(
//                BackoffPolicy.LINEAR,
//                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
//                TimeUnit.MILLISECONDS
//            )
//            .addTag(tag)
//            .setInputData(inputData)
//            .build()
//        WorkManager.getInstance(this).enqueue(oneWorkReq)
//
//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneWorkReq.id)
//            .observe(this, {
//                it.state
//                Logs.log(it.toString())
//            })
//        WorkManager.getInstance(this).beginWith(oneWorkReq).then(oneWorkReq2).enqueue()
//        val list:MutableList<OneTimeWorkRequest> = mutableListOf(oneWorkReq, oneWorkReq2)
//        WorkManager.getInstance(this).beginWith(list).then(oneWorkReq2).enqueue()
//        WorkManager.getInstance(this).beginWith(list).then(list).then(list).enqueue()
//
//
//        val workContinuation1: WorkContinuation  = WorkManager.getInstance(this).beginWith(oneWorkReq).then(oneWorkReq2)
//        val workContinuation2: WorkContinuation = WorkManager.getInstance(this).beginWith(oneWorkReq).then(oneWorkReq2)
//        val taskList: MutableList<WorkContinuation> = ArrayList()
//        taskList.add(workContinuation1)
//        taskList.add(workContinuation2)
//        WorkContinuation.combine(taskList).then(oneWorkReq2).enqueue()
//
//
//        val mWorkContinuation:WorkContinuation = WorkManager.getInstance(this)
//            .beginUniqueWork("beginUniqueWork", ExistingWorkPolicy.APPEND, list).then(oneWorkReq)
//        mWorkContinuation.then(oneWorkReq2).then(oneWorkReq2).enqueue()

    }
}