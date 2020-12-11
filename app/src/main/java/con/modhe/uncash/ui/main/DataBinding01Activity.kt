package con.modhe.uncash.ui.main

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableMap
import con.modhe.uncash.databinding.ActivityDatabinding01Binding
import con.modhe.uncash.ui.main.bean.Order
import con.modhe.uncash.ui.main.bean.Product
import con.modhe.uncash.ui.main.bean.User
import kotlinx.android.synthetic.main.activity_databinding01.*
import java.util.*


/**
 * author Created by harrishuang on 2020-08-14.
 * email : huangjinping1000@163.com
 */


//https://www.jianshu.com/p/bd9016418af2
//https://blog.csdn.net/u013064109/article/details/78786646
class DataBinding01Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDatabinding01Binding
    private lateinit var map: ObservableMap<String, String>
    private lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityDatabinding01Binding>(this, con.modhe.uncash.R.layout.activity_databinding01)
        map = ObservableArrayMap<String, String>() as ObservableMap<String, String>
        map.put("name", "leavesc")
        map.put("age", "24")
        binding.map = map
        var list = ObservableArrayList<String>()
        list.add("Ye")
        list.add("leavesC")

        binding.list = list
        binding.index = 0
        binding.key = "name"
        user = User()


//        btn_apply.setOnClickListener({ data: View ->
//            println("=======123======")
//        })

        btn_apply.setOnClickListener() {
            //            let_method()
//            with_method()
//            run_method()
//            apply_method()
            also_method()
        }
//        btn_apply.setOnClickListener({
//
//        })
//        btn_apply.setOnClickListener({ data ->
//            println("=======1234567======")
//        })

//        btn_apply.setOnClickListener(object : View.OnClickListener {
//
//            override fun onClick(p0: View?) {
//                println("=========onClick============")
//            }
//        })
    }


    fun onAction(view: View) {
        var code = Random().nextInt(100)
        map["name"] = "leavesC,hi${code}"
        var i = { x: Int, y: Int -> x + y }
        println(i(2, 5))
        var j: (Int, Int) -> Int = { x, y -> x + y }
        println(j(4, 8))
    }

    inner class UserPresenter {
        fun onUserNameClick(user: User) {

        }

        fun afterTextChanged(s: Editable) {

        }
    }


    fun let_method() {

//        ```
//        mVideoPlayer?.let {
//            it.setVideoView(activity.course_video_view)
//            it.setControllerView(activity.course_video_controller_view)
//            it.setCurtainView(activity.course_video_curtain_view)
//        }
//
//        ```


        var result = "testLet".let {
            println(it.length)
            it.length
        }
        println(result)

        var view: View? = null
        println("===add_method===")
        view?.let {
            it.setOnClickListener() { view ->
                println("ddddd")
            }
        }
    }


    fun with_method() {
//        ```
//        override fun onBindViewHolder(holder: ViewHolder, position: Int){
//            val item = getItem(position)?: return
//
//            with(item){
//
//                holder.tvNewsTitle.text = StringUtils.trimToEmpty(titleEn)
//                holder.tvNewsSummary.text = StringUtils.trimToEmpty(summary)
//                holder.tvExtraInf.text = "难度：$gradeInfo | 单词数：$length | 读后感: $numReviews"
//                ...
//
//            }
//
//        }
//
//        ```
        var result = with(btn_apply, {
            println("============$text===============")
            1000
        })
        println("==========$result")
    }


    fun run_method() {

//        ```
//        override fun onBindViewHolder(holder: ViewHolder, position: Int){
//            getItem(position)?.run{
//                holder.tvNewsTitle.text = StringUtils.trimToEmpty(titleEn)
//                holder.tvNewsSummary.text = StringUtils.trimToEmpty(summary)
//                holder.tvExtraInf = "难度：$gradeInfo | 单词数：$length | 读后感: $numReviews"
//                ...
//            }
//        }
//
//        ```
        var user = User()
        user.age = 123
        user.id = "0392"
        user.name = "分付君"
        var result = user.run {
            print("============$name=====")
            age
        }
        println("=================>>>>$result>")
    }


    fun apply_method() {
        var user = User()
        user.age = 123
        user.id = "0392"
        user.name = "分付君"
        var result = user.apply {
            println("my name is $name, I am $age years old, my phone number is ")
            1000
        }
        println("result: $result")


        var order = Order()
        var product = Product()
        product.number = 8972
        order.id = "123123"
        order.phone = "138991233"
        order.product = product

        order?.apply {
            println("不为空的操作1")
        }?.product?.apply {
            println("不为空的操作2")
        }?.name?.apply {
            println("不为空的操作3")
        }
    }


    fun also_method() {
        val result = "testLet".also {
            println(it.length)
            1000
        }
        println(result)
    }
}