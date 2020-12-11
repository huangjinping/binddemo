package con.modhe.uncash.ui.main.bean

import android.content.Context
import android.os.Handler
import android.os.Message
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData

/**
 *   author  : AndJun
 *   time    : 2019/3/12
 *   desc    :
 */

class MyLocationLiveData(context: Context) : LiveData<Product>() {


    internal var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            with(msg) {
                var product = Product()
                println("=>>>>>>>>>>>>>>>>>$what")
                product.name = "编号$what"
                product.number = what
                value = product

            }
        }
    }

    @MainThread
    companion object {
        private var sInstance: MyLocationLiveData? = null
        fun getInstance(context: Context): MyLocationLiveData? {
            if (sInstance == null) {
                sInstance = MyLocationLiveData(context.applicationContext)
            }
            return sInstance
        }
    }


    override fun onActive() {
        println("===================onActive=====================")
        var message = handler.obtainMessage()
        message.what = 123
        handler.sendMessageDelayed(handler.obtainMessage(), 3 * 1000)
    }

    override fun onInactive() {
        println("===================onInactive=====================")
        var message = handler.obtainMessage()
        message.what = 12
        handler.sendMessage(message)
    }

}