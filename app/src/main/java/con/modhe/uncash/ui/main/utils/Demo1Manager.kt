package con.modhe.uncash.ui.main.utils

/**
 * author Created by harrishuang on 2020-08-20.
 * email : huangjinping1000@163.com
 */
class Demo1Manager{
    object MyObject {
        fun a() {
            println("此时 object 表示  111 直接声明类")
        }
    }

    companion object {
        private val MY_TAG = "DemoManager"
        fun b() {
            println("此时 companion objec t表示 伴生对象====>>>>")
        }
    }
}