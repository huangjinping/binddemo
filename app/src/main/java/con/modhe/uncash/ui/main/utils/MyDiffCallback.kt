package con.modhe.uncash.ui.main.utils

import android.text.TextUtils
import androidx.recyclerview.widget.DiffUtil
import con.modhe.uncash.ui.main.bean.User

/**
 * author Created by harrishuang on 2020-08-14.
 * email : huangjinping1000@163.com
 */

class MyDiffCallback(var oldList: MutableList<User>, var newList: MutableList<User>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return if (oldList == null) 0 else oldList.size

    }

    override fun getNewListSize(): Int {
        return if (newList == null) 0 else newList.size

    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.get(oldItemPosition).id == newList.get(newItemPosition).id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return TextUtils.equals(oldList.get(oldItemPosition).name, newList.get(newItemPosition).name)
    }


}