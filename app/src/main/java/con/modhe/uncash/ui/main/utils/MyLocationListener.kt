package con.modhe.uncash.ui.main.utils

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * author Created by harrishuang on 2020-09-05.
 * email : huangjinping1000@163.com
 */
class MyLocationListener(var context: Context, var lifecycle: Lifecycle, var callback: Callback) : LifecycleObserver {

    var enabled: Boolean = false


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled) {
            // connect
        }
    }

    fun enable() {
        enabled = true
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        // disconnect if connected
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        println("====create========create===========create======")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun connectOnResume() {
        println("OnResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun connectOnDestory() {
        println("OnDestory")
    }

}