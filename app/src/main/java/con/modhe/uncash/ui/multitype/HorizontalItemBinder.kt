package con.modhe.uncash.ui.multitype

import com.multitype.adapter.binder.MultiTypeBinder
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ItemHorizontalTextBinding

/**
 * date        ：2020/5/8
 * author      ：蒙景博
 * description ：
 */
class HorizontalItemBinder(val index: String): MultiTypeBinder<ItemHorizontalTextBinding>() {

    override fun layoutId(): Int = R.layout.item_horizontal_text

    override fun areContentsTheSame(other: Any): Boolean = other is HorizontalItemBinder
}