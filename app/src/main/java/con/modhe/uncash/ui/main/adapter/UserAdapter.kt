package con.modhe.uncash.ui.main.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import con.modhe.uncash.R
import con.modhe.uncash.ui.main.bean.User

/**
 * author Created by harrishuang on 2020-08-14.
 * email : huangjinping1000@163.com
 */
class UserAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var mDiffer: AsyncListDiffer<User>

    private var diffCallback: DiffCallback

    init {
        diffCallback = DiffCallback()
        mDiffer = AsyncListDiffer(this, diffCallback)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_biffer, parent, false)
        return ViewHolder(view)

    }

    fun submitList(data: List<User>) {
        mDiffer.submitList(data)
    }

    fun getItem(position: Int): User {
        return mDiffer.currentList[position]
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {




        println("===============================$position===")
        var viewHolder: ViewHolder = holder as ViewHolder
        var item = getItem(position)
        viewHolder.txt_left.text = item.name
        viewHolder.txt_right.text = "${item.id}=\n=${item.age}"
        viewHolder.txt_right.setBackgroundColor(item.color)
    }

    fun UserAdapter() {
        mDiffer = AsyncListDiffer(this, diffCallback)
    }


    class DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return TextUtils.equals(oldItem.name, newItem.name)
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
    }

    internal inner class ViewHolder(var rootView: View) : RecyclerView.ViewHolder(rootView) {
        var txt_left: TextView
        var txt_right: TextView

        init {
            this.txt_left = rootView.findViewById<View>(R.id.txt_left) as TextView
            this.txt_right = rootView.findViewById<View>(R.id.txt_right) as TextView
        }
    }

}