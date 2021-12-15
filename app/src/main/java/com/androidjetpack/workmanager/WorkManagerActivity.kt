package com.androidjetpack.workmanager

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.androidjetpack.R
import com.androidjetpack.log.Logs
import kotlinx.android.synthetic.main.activity_work_manager.*
import java.util.concurrent.TimeUnit

public class WorkManagerActivity : AppCompatActivity() {
    val tag = "OneTimeWorkRequest"
    val flag = "PeriodicWorkRequest"

    lateinit var mConstraints: Constraints
    lateinit var oneWorkReq: OneTimeWorkRequest
    lateinit var periodicWork: PeriodicWorkRequest
    lateinit var inputData: Data

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        init()
        tvOneTimeWorkRequest()
        tvPeriodicWorkRequest()
    }

    @SuppressLint("RestrictedApi")
    fun tvOneTimeWorkRequest() {
        tvOneTimeWorkRequest.setOnClickListener {

        }
        inputData = Data.Builder()
            .putString("input_data", "Hello OneTimeWorkRequest")
            .put("ICON", "OneTimeWorkRequest").build()
        oneWorkReq = OneTimeWorkRequest.Builder(CustomWoker::class.java)
            .setConstraints(mConstraints)
            .setInitialDelay(3, TimeUnit.SECONDS)
            .addTag(tag)
            .setInputData(inputData)
            .build()
        WorkManager.getInstance(this).enqueue(oneWorkReq)

        //通过tag标签
        WorkManager.getInstance(this).getWorkInfosByTagLiveData(tag).observe(this, {
            it.forEach {
                Logs.log("${tag}：通过tag标签观察到的：workInfo:" + it)
            }
        })
        //通过id
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneWorkReq.id).observe(this, {
            if (it != null && it.getState() === WorkInfo.State.SUCCEEDED) {
                val outputData: String? = it.outputData.getString("output_data")
                Logs.log("${tag}：通过id观察到的：workInfo:" + outputData)
            }
        })
    }

    @SuppressLint("RestrictedApi")
    fun tvPeriodicWorkRequest() {
        tvPeriodicWorkRequest.setOnClickListener {

        }
        inputData = Data.Builder()
            .putString("input_data", "Hello PeriodicWorkRequest")
            .put("ICON", "PeriodicWorkRequest").build()
        periodicWork = PeriodicWorkRequest
            .Builder(CustomWoker::class.java, 15, TimeUnit.MINUTES)
            .addTag(tag)
//            .setConstraints(mConstraints)
            .setConstraints(Constraints.NONE)
            .setBackoffCriteria(BackoffPolicy.LINEAR, PeriodicWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)
            .setInputData(inputData)
            .build()
        WorkManager.getInstance(this).enqueue(periodicWork)

        //通过tag标签
        WorkManager.getInstance(this).getWorkInfosByTagLiveData(flag).observe(this, {
            it.forEach {
                Logs.log("${flag}：通过tag观察到的：workInfo:" + it.toString())
            }
        })

        //通过id
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWork.id).observe(this, {
            Logs.log("${flag}：通过id观察到的：workInfo:" + it)
        })
    }

    @SuppressLint("IdleBatteryChargingConstraints", "RestrictedApi")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun init() {
        mConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
    }
}