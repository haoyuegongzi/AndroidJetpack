package com.androidjetpack.workmanager

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.androidjetpack.log.Logs
import java.io.File

/**
 *
 * @author: Nixon
 * @ProjectName: AndroidJetpack
 * @Package: com.androidjetpack.workmanager
 * @ClassName: CustomWoker
 * @CreateDate: 2020/11/16 15:52
 * @Description: 本类作用描述：
 * @UpdateUser: 更新者：
 * @UpdateRemark: 更新说明：
 */
public class CustomWoker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {
        val resId = inputData.getString("input_data")
        val icon = inputData.getString("ICON");
        Logs.log("CustomWoker接收到的数据：resId=="+ resId + "，icon==" + icon)

        Thread.sleep(3 * 1000L)
        Logs.log("休眠（耗时操作）之后，执行了一波操作，")
        //TODO:任务在这里执行
        val data = Data.Builder().put("output_data", "work is success")
            .put("deal", "CustomWoker").build();
        return Result.success(data)
    }
}