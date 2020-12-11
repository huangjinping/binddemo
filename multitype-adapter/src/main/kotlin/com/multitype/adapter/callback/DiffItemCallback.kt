package com.multitype.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import com.multitype.adapter.binder.MultiTypeBinder

/**
 * date          : 2019/5/31
 * author        : 蒙景博
 * description   :
 */
class DiffItemCallback<T : MultiTypeBinder<*>> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem.layoutId() == newItem.layoutId()
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem.hashCode() == newItem.hashCode() && oldItem.areContentsTheSame(newItem)
}