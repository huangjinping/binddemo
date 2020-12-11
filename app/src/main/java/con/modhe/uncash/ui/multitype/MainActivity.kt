package con.modhe.uncash.ui.multitype

/**
 * author Created by harrishuang on 2020-08-07.
 * email : huangjinping1000@163.com
 */

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.multitype.adapter.MultiTypeAdapter
import com.multitype.adapter.binder.MultiTypeBinder
import com.multitype.adapter.callback.OnViewClickListener
import com.multitype.adapter.createMultiTypeAdapter
import con.modhe.uncash.BR
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ActivityMultitypeBinding

//https://gitee.com/mengjingbo/multitype-adapter-sample

class MainActivity : AppCompatActivity(), OnViewClickListener {

    private lateinit var mAdapter: MultiTypeAdapter
    private lateinit var binding: ActivityMultitypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_multitype)
        binding.setVariable(BR.data, this)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        mAdapter = createMultiTypeAdapter(binding.multiTypeRecycler, LinearLayoutManager(this))
        setRecyclerViewContent()

        func1()
        func2()
        func3()
    }

    private fun func3() {

    }

    class Runoob {
        var name: String = "12"
        var url: String = "https://www.baidu.com"
        var city: String = "city"
        fun foo() {
            print("Foo")
        } // 成员函数

    }

    private fun func2() {
        var str = "文件类型"
        println("=====func2func2func2func2======");
        for (c in str) {
            println(c)
        }
        println("=====func2func2func2func2======");

        var text = """    
            多行字符串
            多行字符串
            """
        println(text)

        val text1 = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """.trimMargin()
        println(text1)


        var i = 10
        var s = "i = $i"
        println(s)


        val price = """
    ${'$'}9.99
    """
        println(price)


    }


    private fun func1() {
        var a = 1
        var b = 2

        var max = a
        if (a < b) {
            max = b
        }
        println(max)

        val c: Byte = 1
        var i: Int = c.toInt()
        println("========================1111=================$i")

        var l = 1L + 3
        println("===========>>>>>>l======$l")


    }

    fun getStringLenth(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }


    private fun setRecyclerViewContent() {
        mAdapter.notifyAdapterChanged(mutableListOf<MultiTypeBinder<*>>().apply {
            add(TopBannerBinder())
            add(CategoryContainerBinder(listOf("男装", "女装", "鞋靴", "内衣内饰", "箱包", "美妆护肤", "洗护", "腕表珠宝", "手机", "数码").map {
                CategoryItemBinder(it)
            }))
            add(RecommendContainerBinder((1..8).map { RecommendGoodsBinder() }))
            add(HorizontalScrollBinder((0..11).map { it }))
            add(GoodsGridContainerBinder((1..20).map { GoodsBinder() }))
        })
    }

    override fun onClick(view: View, any: Any?) {
//        if (view.id == R.id.multi_type_item_text) {
//            Log.e(this.javaClass.simpleName, "${any}被点击")
//        }
    }
}
