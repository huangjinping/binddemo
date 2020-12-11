package con.modhe.uncash.ui.multitype

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.multitype.adapter.binder.MultiTypeBinder
import com.multitype.adapter.createMultiTypeAdapter
import com.multitype.adapter.invoke
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ItemHorizontalScrollContainerBinding

/**
 * date        ：2020/5/8
 * author      ：蒙景博
 * description ：
 */
class HorizontalScrollBinder(val data: List<Int>): MultiTypeBinder<ItemHorizontalScrollContainerBinding>() {

    override fun layoutId(): Int = R.layout.item_horizontal_scroll_container

    override fun areContentsTheSame(other: Any): Boolean = other is HorizontalScrollBinder && other.data == data

    override fun onBindViewHolder(binding: ItemHorizontalScrollContainerBinding) {
        (createMultiTypeAdapter(binding.multiTypeScrollRecycler, LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false))) {
           notifyAdapterChanged(data.map {
               HorizontalItemBinder("$it")
           })
        }
    }
}