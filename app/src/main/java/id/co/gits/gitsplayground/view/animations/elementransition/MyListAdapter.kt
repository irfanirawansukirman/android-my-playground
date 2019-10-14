package id.co.gits.gitsplayground.view.animations.elementransition

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import id.co.gits.gitsplayground.R

class MyListAdapter(private val dataMyList: List<MyListModel>,
                    private val itemCourierListener: MyListCourier) : androidx.recyclerview.widget.RecyclerView.Adapter<MyListAdapter.ItemHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(p0.context).inflate(R.layout.list_item, p0, false))
    }

    override fun getItemCount() = dataMyList.size

    override fun onBindViewHolder(p0: ItemHolder, p1: Int) {
        p0.bindItem(dataMyList[p1], itemCourierListener)
    }


    class ItemHolder(private val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        fun bindItem(item: MyListModel, itemCourierListener: MyListCourier) {
            view.apply {
                findViewById<TextView>(R.id.txt_list_title).text = item.title
                findViewById<TextView>(R.id.txt_list_desc).text = item.desc
                Glide.with(findViewById<ImageView>(R.id.img_list)).load(item.urlImage)
                        .into(findViewById(R.id.img_list))
                findViewById<LinearLayout>(R.id.lin_list_container).setOnClickListener {
                    val views = arrayListOf<View>().apply {
                        add(findViewById(R.id.img_list))
                        add(findViewById(R.id.txt_list_title))
                        add(findViewById(R.id.txt_list_desc))
                    }

                    itemCourierListener.onItemClicked(item, views)
                }
            }
        }
    }
}