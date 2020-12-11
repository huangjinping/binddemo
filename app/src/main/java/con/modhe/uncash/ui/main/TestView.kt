package con.modhe.uncash.ui.main

import con.modhe.uncash.ui.main.utils.Demo1Manager
import con.modhe.uncash.ui.main.utils.DemoManager

/**
 * author Created by harrishuang on 2020-08-15.
 * email : huangjinping1000@163.com
 */


val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

fun main(args: Array<String>) {
//    println("========")
//    class BaseProxy(base: Base) : Base by base
//
//    val base = BaseImpl()
//    BaseProxy(base).show()
//
//    class SportsManager(sport: ISports) : ISports by sport
//
//    val swimSports: SwimForSports = SwimForSports()
//    SportsManager(swimSports).doSports()// Log：do swim
//
//    var list = 1..100
//    for (i in list step 3) {
//        println(i)
//    }
//    println(lazyValue)
//    println(lazyValue)
//    println(lazyValue)
//    println(lazyValue)
//    DemoManager.a()

//    Demo1Manager.MyObject.a()

    Demo1Manager.b()
}