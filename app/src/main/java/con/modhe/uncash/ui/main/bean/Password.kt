package con.modhe.uncash.ui.main.bean

import con.modhe.uncash.ui.main.Printable

/**
 * author Created by harrishuang on 2020-08-15.
 * email : huangjinping1000@163.com
 */
inline class Password(val value: String) : Printable {
    override fun prettyPrint(): String {
        println("======Password===Password=>>>>>>>==")
        return "prettyPrint"
    }
}