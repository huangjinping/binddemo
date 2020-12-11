package con.modhe.uncash.ui.main

import android.app.Application

/**
 * author Created by harrishuang on 2020-08-20.
 * email : huangjinping1000@163.com
 */
class App : Application() {


    init {
        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}