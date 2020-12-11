package con.modhe.uncash.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ActivityWorkmangerDemoBinding
import con.modhe.uncash.ui.main.utils.MyWorkA
import java.util.concurrent.TimeUnit

/**
 * author Created by harrishuang on 2020-08-15.
 * email : huangjinping1000@163.com
 */

//https://www.jianshu.com/p/b65461c79934
class WorkMangerDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWorkmangerDemoBinding
    private var TAG: String = "WorkMangerDemoActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityWorkmangerDemoBinding>(this, R.layout.activity_workmanger_demo)
    }

    fun onAction(view: View) {
        Toast.makeText(this, "caction", Toast.LENGTH_LONG).show()

//        func0()
//        func1()
        func2()

    }

    fun func0() {
        val workRequestA = OneTimeWorkRequest.Builder(MyWorkA::class.java).build()
        WorkManager.getInstance().enqueue(workRequestA)
        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequestA.id)
                .observe(this, Observer {
                    Log.i(TAG, it?.state?.name)
                    if (it?.state!!.isFinished) {
                        Log.i(TAG, "Finish !")
                    }
                })
    }

    fun func1() {
        val myConstrains = Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiresDeviceIdle(true)
                .build()

        val compressionWork = OneTimeWorkRequest.Builder(MyWorkA::class.java)
                .setConstraints(myConstrains)
                .build()

        WorkManager.getInstance().enqueue(compressionWork)
        WorkManager.getInstance().cancelWorkById(compressionWork.id)

    }

    fun func2() {
//        val myConstrains = Constraints.Builder()
//                .setRequiresCharging(true)
//                .setRequiresDeviceIdle(true)
//                .build()
//        val compressionWork = OneTimeWorkRequest.Builder(MyWorkA::class.java)
//                .setConstraints(myConstrains)
//                .build()
//        WorkManager.getInstance().enqueue(compressionWork)

        val repeatRequest = PeriodicWorkRequest.Builder(MyWorkA::class.java, 10, TimeUnit.SECONDS).build()
        WorkManager.getInstance().enqueue(repeatRequest)


    }

}
