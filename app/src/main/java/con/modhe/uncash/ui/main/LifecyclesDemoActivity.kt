package con.modhe.uncash.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ActivityLifecyclesDemoBinding
import con.modhe.uncash.ui.main.utils.MyLifecyckleCallback
import con.modhe.uncash.ui.main.utils.MyObserver

/**
 * author Created by harrishuang on 2020-08-15.
 * email : huangjinping1000@163.com
 */
class LifecyclesDemoActivity : AppCompatActivity() {
    private lateinit var myObserver: MyObserver

    private lateinit var binding: ActivityLifecyclesDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLifecyclesDemoBinding>(this, R.layout.activity_lifecycles_demo)
//        lifecycleRegistry = LifecycleRegistry(this)
//        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        myObserver = MyObserver(this,object : MyLifecyckleCallback {
            override fun update(string: String) {
                Toast.makeText(this@LifecyclesDemoActivity, string, Toast.LENGTH_SHORT).show()

            }
        })
//        lifecycleRegistry.addObserver(myObserver)
        startAnimation()

        runOnUiThread(object : Runnable {
            override fun run() {

            }
        })

        lifecycle.addObserver(myObserver)
    }


    fun startAnimation() {

//        var tmap = HashMap<String, Int>()
//        tmap.set("a", 1)
//        tmap.set("b", 2)
//        tmap.set("c", 3)
//        tmap.set("b", 4)
//        tmap.set("e", 5)
//        tmap.set("f", 6)
//        tmap.set("g", 7)
//
//        println("========startAnimation==========")
//        println(tmap)
//        println("========startAnimation==========")
//
//        var map = mapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
//        println(map)//按添加顺序排列
//        println("mapOf的返回对象的实际类型：${map.javaClass}")


//        //创建可变集合
//        var mutableMap = mutableMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
//        println(mutableMap)//按添加顺序排列
//        println("mutableMapOf的返回对象的实际类型：${mutableMap.javaClass}")
//        //创建HashMap集合
//        var hashMap = hashMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
//        println(hashMap)//不保证排列顺序
//        println("hashMapOf的返回对象的实际类型：${hashMap.javaClass}")
//        //创建LinkedHashMap
//        var linkedHashMap = linkedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
//        println(linkedHashMap)//按添加顺序排列
//        println("linkedMapOf的返回对象的实际类型：${linkedHashMap.javaClass}")
//        //创建TreeMap集合
//        var treeMap = sortedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
//        println(treeMap)//按key由小到大排列
//        println("sortedMapOf的返回对象的实际类型：${treeMap.javaClass}")

        object : Thread() {
            override fun run() {


            }
        }.start()

        object : Thread() {
            override fun run() {

            }
        }.start()

    }

    fun onActionView(view: View) {
        Toast.makeText(this, "onActionView", Toast.LENGTH_LONG).show()

    }

    override fun onStart() {
        super.onStart()
//        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun onResume() {
        super.onResume()
//        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    override fun onStop() {
        super.onStop()
//        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    override fun onDestroy() {
        super.onDestroy()
//        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }


}