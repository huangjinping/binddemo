package con.modhe.uncash.ui.main.bean

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * author Created by harrishuang on 2020-08-15.
 * email : huangjinping1000@163.com
 */
class TestViewModel : ViewModel() {
    var mCurrent: MutableLiveData<String>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }
}