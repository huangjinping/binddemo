package con.modhe.uncash.ui.main.utils

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


/**
 * author Created by harrishuang on 2020-08-15.
 * email : huangjinping1000@163.com
 */
class MyObserver(var mContext: Context, var myLifecyckleCallback: MyLifecyckleCallback) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun connectOnCreate() {
//        println("OnCreate")
        object : Thread() {
            override fun run() {
                super.run()
                Log.d("okhttp", "=========Thread================")
                Thread.sleep(5 * 1000)
                var activity = mContext as AppCompatActivity
                activity.runOnUiThread(object : Runnable {
                    override fun run() {
                        Log.d("okhttp", "====runOnUiThread=====")

                        println("==runOnUiThread=====")
                        myLifecyckleCallback.update("after View")
                    }
                })
            }
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun connectOnResume() {
//        println("OnResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun connectOnStart() {
//        println("OnStart")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun connectOnDestory() {
//        println("OnDestory")
    }

    fun println(string: String) {
        myLifecyckleCallback.update(string)
    }

}