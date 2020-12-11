package con.modhe.uncash.ui.multitype

import androidx.recyclerview.widget.GridLayoutManager
import com.multitype.adapter.binder.MultiTypeBinder
import com.multitype.adapter.createMultiTypeAdapter
import com.multitype.adapter.invoke
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ItemCategoryChildBinding
import con.modhe.uncash.databinding.ItemCategoryContainerBinding

/**
 * date        ：2020/5/21
 * author      ：蒙景博
 * description ：
 */
class CategoryContainerBinder(val category: List<CategoryItemBinder>): MultiTypeBinder<ItemCategoryContainerBinding>() {

    override fun layoutId(): Int = R.layout.item_category_container

    override fun areContentsTheSame(other: Any): Boolean = other is CategoryContainerBinder && other.category == category

    override fun onBindViewHolder(binding: ItemCategoryContainerBinding) {
        (createMultiTypeAdapter(binding.categoryRecycler, GridLayoutManager(binding.root.context, 5))) {
            notifyAdapterChanged(category)
        }
    }
}

class CategoryItemBinder(val title: String): MultiTypeBinder<ItemCategoryChildBinding>() {

    override fun layoutId(): Int = R.layout.item_category_child

    override fun areContentsTheSame(other: Any): Boolean = other is CategoryItemBinder && other.title == title

}