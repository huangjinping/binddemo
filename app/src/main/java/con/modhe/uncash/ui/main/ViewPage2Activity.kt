package con.modhe.uncash.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.saeed.infiniteflow.lib.OverlapSliderTransformer
import con.modhe.uncash.R
import con.modhe.uncash.databinding.ActivityViewpage2Binding
import kotlinx.android.synthetic.main.activity_viewpage2.*
import java.util.*
import kotlin.collections.ArrayList


/**
 * author Created by harrishuang on 2020-09-08.
 * email : huangjinping1000@163.com
 */
class ViewPage2Activity : AppCompatActivity() {

    lateinit var binding: ActivityViewpage2Binding
    lateinit var dataList: MutableList<String>
    lateinit var adapter: MyDataApdater
    var tempPosition: Int = 0
    val sidePage: Int = 1
    var needPage: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityViewpage2Binding>(this, R.layout.activity_viewpage2)
        vip_index.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        dataList = ArrayList()
        dataList.add("1")
        dataList.add("2")
        dataList.add("3")
        dataList.add("4")
        adapter = MyDataApdater()

        var compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(OverlapSliderTransformer(vip_index.orientation, 0.25f, 0f, 1f, 0f))
        vip_index.setPageTransformer(compositePageTransformer)

        vip_index.registerOnPageChangeCallback(OnPageChangeCallback())
        vip_index.adapter = adapter
    }


    inner class OnPageChangeCallback : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            if (getRealCount() > 1) {
                tempPosition = position
            }
        }

        override fun onPageScrollStateChanged(state: Int) {
            if (state == ViewPager2.SCROLL_STATE_DRAGGING) {
                Log.d("okhttp", "tempPosition:" + tempPosition + "===========--getRealCount:" + getRealCount() + "-----==========sidePage:" + sidePage)
                if (tempPosition == sidePage - 1) {
                    vip_index.setCurrentItem(getRealCount() + tempPosition, false)
                } else if (tempPosition == getRealCount() + sidePage) {
                    vip_index.setCurrentItem(sidePage, false)
                } else {
                }
            }
        }




    }

    fun getRealCount(): Int {
        return dataList.size
    }

    private fun toRealPosition(position: Int): Int {
        var realPosition = 0
        if (getRealCount() > 1) {
            realPosition = (position - sidePage) % getRealCount()
        }
        if (realPosition < 0) {
            realPosition += getRealCount()
        }
        return realPosition
    }

    inner class MyDataApdater() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return dataList.size + needPage
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            Log.d("okhttp", "=========>>>>>>>>>" + toRealPosition(position))
            var title = dataList[toRealPosition(position)]
            var viewHolder: ViewHolder = holder as ViewHolder
            viewHolder.txt_item_pager.text = title



            val random = Random()
            val ranColor = -0x1000000 or random.nextInt(0x00ffffff)
            viewHolder.txt_item_pager.setBackgroundColor(ranColor)
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var txt_item_pager: TextView

            init {
                txt_item_pager = view.findViewById(R.id.txt_item_pager) as TextView
            }
        }
    }


}