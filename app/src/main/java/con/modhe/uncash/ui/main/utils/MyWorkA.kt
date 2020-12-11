package con.modhe.uncash.ui.main.utils

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * author Created by harrishuang on 2020-08-15.
 * email : huangjinping1000@163.com
 */
class MyWorkA(context: Context, workerParameters: WorkerParameters) : Worker(context,     workerParameters) {

    override fun doWork(): Result {
        Log.i("asdasd","doWork A !")

        Thread.sleep(1000)
        println("+++++++++asdasdasdasdasdasdasdasd++++++++++++++++asdasdasdasdasdasdasdasd++++++++++++++asdasdasdasdasdasdasdasd++++++++++++++++++++++")
        // 模拟任务执行成功
        return Result.SUCCESS
    }
}