package con.modhe.uncash.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ActivityMyBinding
import con.modhe.uncash.ui.main.utils.Callback
import con.modhe.uncash.ui.main.utils.MyLocationListener
import kotlinx.android.synthetic.main.activity_my.*


/**
 * author Created by harrishuang on 2020-09-05.
 * email : huangjinping1000@163.com
 */
class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMyBinding>(this, R.layout.activity_my)

        var myLocationListener = MyLocationListener(this, lifecycle, object : Callback {
            override fun onResult(result: String) {

            }
        })
        lifecycle.addObserver(myLocationListener)
        btn_action.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                myLocationListener.enable()
                println("btn_action  action view  setOnClickListener  ")
            }
        })
//        Util.checkUserStatus({ result ->
//            if (result) {
//                myLocationListener.enable()
//            }
//        })

    }
}