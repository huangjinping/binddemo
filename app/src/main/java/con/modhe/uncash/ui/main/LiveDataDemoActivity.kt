package con.modhe.uncash.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ActivityLiveDatademoBinding
import con.modhe.uncash.ui.main.bean.MyLocationLiveData
import con.modhe.uncash.ui.main.bean.TestViewModel
import kotlinx.android.synthetic.main.activity_list.*


/**
 * author Created by harrishuang on 2020-08-15.
 * email : huangjinping1000@163.com
 */

//https://www.jianshu.com/p/dbf3843b8cd1
class LiveDataDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveDatademoBinding

    private lateinit var testViewModel: TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLiveDatademoBinding>(this, R.layout.activity_live_datademo)
        testViewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        // 创建观察者对象
//        val nameObservable = Observer<String> {
//            btn_action.text = it // onChange() 方法中的操作
//        }
//        testViewModel.mCurrent!!.observe(this, nameObservable)
        MyLocationLiveData(this).observe(this, Observer {
            btn_action.text = it.name
        })

    }


    fun onAction(view: View) {
        Toast.makeText(this, "csview", Toast.LENGTH_LONG).show()
        val anotherName = "John Doe"
        testViewModel.mCurrent!!.value = anotherName
    }
}