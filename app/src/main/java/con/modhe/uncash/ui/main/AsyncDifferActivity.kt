package con.modhe.uncash.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import con.modhe.uncash.R
import con.modhe.uncash.ui.main.adapter.AsyncDifferAdapter
import con.modhe.uncash.ui.main.adapter.UserAdapter
import con.modhe.uncash.ui.main.bean.User
import con.modhe.uncash.ui.main.utils.MyDiffCallback
import java.util.*
import kotlin.collections.ArrayList


/**
 * author Created by harrishuang on 2020-08-13.
 * email : huangjinping1000@163.com
 *
 */

class AsyncDifferActivity : AppCompatActivity() {

    private lateinit var rec_list: RecyclerView
    private lateinit var mAdapter: UserAdapter
    private lateinit var dataList: MutableList<User>
    private lateinit var oldList: MutableList<User>
    private lateinit var newList: MutableList<User>
    private lateinit var mAsyncDifferAdapter: AsyncDifferAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asyncdiffer)
        dataList = ArrayList()
        rec_list = findViewById(R.id.rec_list)

        rec_list.layoutManager = LinearLayoutManager(this)
//        onAsyncDiffer()
        onDiffUtil()
    }

    fun onDiffUtil() {
        oldList = ArrayList()
        var temList = listOf("男装", "女装", "鞋靴", "内衣内饰", "箱包", "美妆护肤", "洗护", "腕表珠宝", "手机", "数码")
        for (index in temList.indices) {
            println(temList.get(index))
            var user = User()
            user.id = "$index"
            user.age = (Math.random() * 100).toInt()
            user.name = temList.get(index)
            user.color = getRandomColor()
            oldList.add(user)
        }
        mAsyncDifferAdapter = AsyncDifferAdapter(oldList)
        rec_list.adapter = mAsyncDifferAdapter
    }

    fun onAsyncDiffer() {
        mAdapter = UserAdapter()
        var temList = listOf("男装", "女装", "鞋靴", "内衣内饰", "箱包", "美妆护肤", "洗护", "腕表珠宝", "手机", "数码")
        for (index in temList.indices) {
            println(temList.get(index))
            var user = User()
            user.id = "$index"
            user.age = (Math.random() * 100).toInt()
            user.name = temList.get(index)
            user.color = getRandomColor()
            dataList.add(user)
        }
        mAdapter.submitList(dataList)
        rec_list.adapter = mAdapter
        mAdapter.notifyDataSetChanged()

    }

    fun getRandomColor(): Int {
        val random = Random()
        var r = 0
        var g = 0
        var b = 0
        for (i in 0..1) {
            //       result=result*10+random.nextInt(10);
            var temp = random.nextInt(16)
            r = r * 16 + temp
            temp = random.nextInt(16)
            g = g * 16 + temp
            temp = random.nextInt(16)
            b = b * 16 + temp
        }
        return Color.rgb(r, g, b)
    }

    fun onItem(view: View) {


        var temList = listOf("男装", "女123123装", "鞋--靴", "内衣内饰", "箱包", "美妆护肤", "洗护", "腕表珠宝", "手机", "数码")
        newList = ArrayList()
        for (index in temList.indices) {
            println(temList.get(index))
            var user = User()
            user.id = "$index"
            user.age = (Math.random() * 100).toInt()
            user.name = temList.get(index)
            user.color = getRandomColor()
            newList.add(user)
        }
        var diffCallback = MyDiffCallback(newList, oldList)
        var diffResult = DiffUtil.calculateDiff(diffCallback)
        mAsyncDifferAdapter.setData(newList)
        diffResult.dispatchUpdatesTo(mAsyncDifferAdapter)


//        var temList = listOf("男装", "女123123装", "鞋靴", "内衣内饰", "箱包", "美妆护肤", "洗护", "腕表珠宝", "手机", "数码")
//        var userList: MutableList<User> = ArrayList()
//        for (index in temList.indices) {
//            println(temList.get(index))
//            var user = User()
//            user.id = "$index"
//            user.age = (Math.random() * 100).toInt()
//            user.name = temList.get(index)
//            user.color = getRandomColor()
//            userList.add(user)
//        }
//        mAdapter.submitList(userList)


        Toast.makeText(this, "Activity  add  View  Package", Toast.LENGTH_LONG).show()
    }
}