package con.modhe.uncash.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import con.modhe.uncash.R
import con.modhe.uncash.ui.main.bean.User

/**
 * author Created by harrishuang on 2020-08-13.
 * email : huangjinping1000@163.com
 */
class AsyncDifferAdapter(var dataList: MutableList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_biffer, parent, false)
        return ViewHolder(view)
    }


    fun setData(data: MutableList<User>) {
        dataList = data
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder: ViewHolder = holder as ViewHolder
        var item = dataList.get(position)
        viewHolder.txt_left.text = item.name
        viewHolder.txt_right.text = "${item.id}=\n=${item.age}"
        viewHolder.txt_right.setBackgroundColor(item.color)
    }

    class ViewHolder(var rootView: View) : RecyclerView.ViewHolder(rootView) {
        var txt_left: TextView
        var txt_right: TextView

        init {
            txt_left = rootView.findViewById(R.id.txt_left)
            txt_right = rootView.findViewById(R.id.txt_right)
        }
    }

}

