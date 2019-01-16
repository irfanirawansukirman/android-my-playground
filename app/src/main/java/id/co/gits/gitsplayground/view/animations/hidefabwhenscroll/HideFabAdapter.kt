package id.co.gits.gitsplayground.view.animations.hidefabwhenscroll

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.R

class HideFabAdapter : RecyclerView.Adapter<HideFabAdapter.ItemHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(p0.context).inflate(
                R.layout.list_item, p0, false
        ))
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(p0: ItemHolder, p1: Int) {

    }

    class ItemHolder(private val view:View): RecyclerView.ViewHolder(view) {
        fun bindItem(){}
    }
}