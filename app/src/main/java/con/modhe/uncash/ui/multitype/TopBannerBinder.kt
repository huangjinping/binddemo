package con.modhe.uncash.ui.multitype

import com.multitype.adapter.binder.MultiTypeBinder
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ItemTopBannerBinding

/**
 * date        ：2020/5/21
 * author      ：蒙景博
 * description ：
 */
class TopBannerBinder: MultiTypeBinder<ItemTopBannerBinding>() {

    override fun layoutId(): Int = R.layout.item_top_banner

    override fun areContentsTheSame(other: Any): Boolean = other is TopBannerBinder
}