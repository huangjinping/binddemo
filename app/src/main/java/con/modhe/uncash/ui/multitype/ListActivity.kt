package con.modhe.uncash.ui.multitype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ActivityListBinding
import con.modhe.uncash.ui.main.App
import con.modhe.uncash.ui.main.bean.Case
import kotlinx.android.synthetic.main.activity_list.*
import kotlin.reflect.typeOf

/**
 * author Created by harrishuang on 2020-08-10.
 * email : huangjinping1000@163.com
 */
class ListActivity : AppCompatActivity(), View.OnClickListener {


    var binding: ActivityListBinding? = null
    var dataList: ArrayList<Case>? = null
    var mAdapter: DataAdapter? = null
    val asd="asdasd"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityListBinding>(this, R.layout.activity_list)
        btn_action.setOnClickListener(this)
        dataList = ArrayList()
        var len = 1..100
        for (i in len) {
            var case = Case()
            case.id = Math.random().toLong()
            case.name = "case$i"
            dataList!!.add(case)
        }
        mAdapter = DataAdapter()
        rec_list.layoutManager = LinearLayoutManager(this)
        rec_list.adapter = mAdapter
        println(App.instance)
    }


    override fun onClick(view: View?) {
        var id = view!!.id
        when (id) {
            R.id.btn_action -> {
                println("========btn_action=========")
            }
        }
    }

    inner class DataAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_data_demo, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            var dsize = dataList!!.size
            return dsize
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewHolder: ViewHolder = holder as ViewHolder
            var item = dataList!!.get(position)
            with(item) {
                viewHolder.txt_action_name!!.text = name
            }
        }

        inner class ViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
            var txt_action_name: TextView? = null

            init {
                txt_action_name = rootView.findViewById(R.id.txt_action_name)
            }
        }
    }
}