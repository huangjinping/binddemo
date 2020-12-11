package con.modhe.uncash.ui.multitype

import androidx.recyclerview.widget.GridLayoutManager
import com.multitype.adapter.binder.MultiTypeBinder
import com.multitype.adapter.createMultiTypeAdapter
import com.multitype.adapter.invoke
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ItemGoodsBinding
import con.modhe.uncash.databinding.ItemGoodsGridContainerBinding
import con.modhe.uncash.ui.multitype.GridLayoutDecorationDivider


/**
 * date        ：2020/5/21
 * author      ：蒙景博
 * description ：
 */
class GoodsGridContainerBinder(val goods: List<GoodsBinder>): MultiTypeBinder<ItemGoodsGridContainerBinding>() {

    override fun layoutId(): Int = R.layout.item_goods_grid_container

    override fun areContentsTheSame(other: Any): Boolean = other is GoodsGridContainerBinder && other.goods == goods

    override fun onBindViewHolder(binding: ItemGoodsGridContainerBinding) {
        binding.goodsRecycler.addItemDecoration(GridLayoutDecorationDivider(binding.root.context, 2, 10))
        (createMultiTypeAdapter(binding.goodsRecycler, GridLayoutManager(binding.root.context, 2))) {
            notifyAdapterChanged(goods)
        }
    }
}


class GoodsBinder: MultiTypeBinder<ItemGoodsBinding>() {

    override fun layoutId(): Int = R.layout.item_goods

    override fun areContentsTheSame(other: Any): Boolean = other is GoodsBinder
}