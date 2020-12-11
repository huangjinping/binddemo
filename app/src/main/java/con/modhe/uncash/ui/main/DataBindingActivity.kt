package con.modhe.uncash.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ActivityDatabindingBinding
import con.modhe.uncash.ui.main.bean.Goods
import con.modhe.uncash.ui.main.bean.MyBean
import java.util.*


/**
 * author Created by harrishuang on 2020-08-14.
 * email : huangjinping1000@163.com
 */

//https://www.jianshu.com/p/bd9016418af2
class DataBindingActivity : AppCompatActivity() {
    private lateinit var goods: Goods
    private lateinit var binding: ActivityDatabindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityDatabindingBinding>(this, R.layout.activity_databinding)
        goods = Goods()
        goods.name = "goodName"
        goods.price = 123
        goods.details = "goodDetails View"
        binding.goods = goods
        binding.goodsHandler = GoodsHandler()
        var bean = MyBean("123  text  view")
        binding.bean = bean
//        goods.addOnPropertyChangedCallback(OnPropertyChangedCallback)
        goods.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                println("=====================>>>>>>")
            }
        })
    }

    fun onAction(view: View) {
        Toast.makeText(this, "onAction", Toast.LENGTH_LONG).show()
        var bean = MyBean("onAction onAction")
        binding.bean = bean
    }

    fun onActionView(view: View) {
        Toast.makeText(this, "onActionView", Toast.LENGTH_LONG).show()

    }

    inner class GoodsHandler {
        fun changeGoodsName() {
            var code = Random().nextInt(100)
            goods.name = "code$code"
            goods.price = Random().nextInt(100)
            println("======changeGoodsName========${goods.price}")

        }

        fun changeGoodsDetails() {
            var code = Random().nextInt(100)
            goods.details = "hi$code"
            goods.price = Random().nextInt(100)
            println("======changeGoodsDetails========${goods.details}")
        }
    }
}

