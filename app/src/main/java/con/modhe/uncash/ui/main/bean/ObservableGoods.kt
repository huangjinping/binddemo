package con.modhe.uncash.ui.main.bean

import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat

/**
 * author Created by harrishuang on 2020-08-14.
 * email : huangjinping1000@163.com
 */


data class ObservableGoods(var id: String = "") {
    var name: ObservableField<String>? = null
    var price: ObservableFloat? = null
    var details: ObservableField<String>? = null

}