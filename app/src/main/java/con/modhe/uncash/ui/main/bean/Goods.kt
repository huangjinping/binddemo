package con.modhe.uncash.ui.main.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * author Created by harrishuang on 2020-08-14.
 * email : huangjinping1000@163.com
 */
data class Goods(var id: String = "") : BaseObservable() {
    @Bindable
    var name: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
    @Bindable
    var details: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.details)
        }
    var price: Int = 0
}